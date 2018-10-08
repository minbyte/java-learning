package com.mindasoft._06_thread.threadPool;

import java.util.concurrent.*;

/**
 * 线程池扩展
 * 在ThreadPoolExecutor中提供了三个专门供子类覆盖/重写的方法：beforeExecute(Thread t, Runnable r)、afterExecute(Runnable r, Throwable t)和terminated()。这三个方法可以帮助程序员，在线程池处理任务的不同阶段，进行额外的业务处理操作：
 *   beforeExecute：当线程池正要开始执行某个任务的时候（注意不是任务进入等待队列的时候，是将要开始正式在线程池中执行的时候），线程池会触发这个方法的调用。
 *   afterExecute：当线程池完成了某一个任务的执行后，线程池就会触发这个方法。
 *   terminated：当线程池本身停止执行的时候，该方法就会被调用。
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/8 13:38
 */
public class ThreadPoolExecutorExtendsLearning extends ThreadPoolExecutor {

    public static void main(String[] args) throws Throwable {
        // 这个做法，是故意让后续index == 5 - 9的线程进入等待队列。以便观察执行现象
        ThreadPoolExecutorExtendsLearning extendsPool = new ThreadPoolExecutorExtendsLearning(
                5, 5, 10000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for(int index = 0 ; index < 10 ; index ++) {
            // 一定要使用execute，不要使用submit。
            extendsPool.execute(new TestRunnable(index));
        }
        //execute方法：所有实现了Runnable接口的任务都可以使用execute方法进行提交。而实现了Runnable接口的任务，
        // 并没有提供任何“标准”的方式为我们返回任务的执行结果（这是我们还没有讲到的知识点）。线程在线程池中运行结束了，就结束了。
        // 所以，使用execute方法提交的任务，程序员并不能在任务执行完成后，获得一个“标准”的执行结果。
        //submit方法：submit方法提交的任务是实现了Callable接口的任务（这是我们还没有讲到的知识点）。
        // Callable接口的特性是，在其运行完成后，会返回一个“标准”的执行结果。

        // 发出停止指令。注意停止指令本身不会等待，要使用awaitTermination进行等待。
        // 注意，按照我们上文讲过的线程池的工作原理，线程池在收到shutdown终止指令后
        // 就不会再接受提交过来的任务了，无论“核心线程”、等待队列处于什么样的状态！
        extendsPool.shutdown();
        // 当所有任务执行完成后，终止线程池的运行
        extendsPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
    }


    public ThreadPoolExecutorExtendsLearning(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.ThreadPoolExecutor#beforeExecute(java.lang.Thread, java.lang.Runnable)
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        TestRunnable testRunnable = (TestRunnable)r;
        System.out.println("beforeExecute(Thread t, Runnable r) : " + testRunnable.getIndex());
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.ThreadPoolExecutor#afterExecute(java.lang.Runnable, java.lang.Throwable)
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        TestRunnable testRunnable = (TestRunnable)r;
        System.out.println("afterExecute(Runnable r, Throwable t) : " + testRunnable.getIndex());
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.ThreadPoolExecutor#terminated()
     */
    @Override
    protected void terminated() {
        System.out.println("terminated() ！！");
    }

    /**
     * 这个就是测试用的线程
     * @author yinwenjie
     */
    private static class TestRunnable implements Runnable {

        /**
         * 记录任务的唯一编号，这样在日志中好做识别
         */
        private Integer index;

        public TestRunnable(int index) {
            this.index = index;
        }

        /**
         * @return the index
         */
        public Integer getIndex() {
            return index;
        }

        @Override
        public void run() {
            /*
             * 线程中，就只做一件事情：
             * 等待10秒钟的事件，以便模拟业务操作过程
             * */
            Thread currentThread  = Thread.currentThread();
            synchronized (currentThread) {
                try {
                    currentThread.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }

}
