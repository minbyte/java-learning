package com.mindasoft._06_thread._04_threadPool;

import org.junit.Test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * 实例化线程池的参数：
 * corePoolSize：核心大小，线程池初始化的时候，就会有这么大
 * maximumPoolSize：线程池最大线程数
 * keepAliveTime：如果当前线程池中线程数大于corePoolSize。
 * 多余的线程，在等待keepAliveTime时间后如果还没有新的线程任务指派给它，它就会被回收
 * unit：等待时间keepAliveTime的单位
 *
 * workQueue：指定一个实现了BlockingQueue接口的任务等待队列.
 * 使用推荐：SynchronousQueue、LinkedBlockingQueue和ArrayBlockingQueue
 * 还有：PriorityBlockingQueue、LinkedBlockingDeque和LinkedTransferQueue
 * 1、SynchronousQueue：这是一个内部没有任何容量的阻塞队列，任何一次插入操作的元素都要等待相对的删除/读取操作，否则进行插入操作的线程就要一直等待，反之亦然
 * SynchronousQueue<Object> queue = new SynchronousQueue<Object>();
 *   // 不要使用add，因为这个队列内部没有任何容量，所以会抛出异常“IllegalStateException”
 *   // queue.add(new Object());
 *   // 操作线程会在这里被阻塞，直到有其他操作线程取走这个对象
 *   queue.put(new Object());
 * 2、ArrayBlockingQueue：一个由数组支持的有界阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序。一旦创建了这样的缓存区，就不能再增加其容量。
 * // 我们创建了一个ArrayBlockingQueue，并且设置队列空间为2
 *   ArrayBlockingQueue<Object> arrayQueue = new ArrayBlockingQueue<Object>(2);
 *   // 插入第一个对象
 *   arrayQueue.put(new Object());
 *   // 插入第二个对象
 *   arrayQueue.put(new Object());
 *   // 插入第三个对象时，这个操作线程就会被阻塞。
 *   arrayQueue.put(new Object());
 *   // 请不要使用add操作，和SynchronousQueue的add操作一样，它们都使用了AbstractQueue中的add实现
 * 3、LinkedBlockingQueue是我们在ThreadPoolExecutor线程池中常应用的等待队列。它可以指定容量也可以不指定容量。
 * LinkedBlockingDeque<TempObject> linkedDeque = new LinkedBlockingDeque<TempObject>();
 *   // push ，可以从队列的头部插入元素
 *   linkedDeque.push(new TempObject(1));
 *   linkedDeque.push(new TempObject(2));
 *   linkedDeque.push(new TempObject(3));
 *   // poll ， 可以从队列的头部取出元素
 *   TempObject tempObject = linkedDeque.poll();
 *   // 这里会打印 tempObject.index = 3
 *   System.out.println("tempObject.index = " + tempObject.getIndex());
 *
 *   // put ， 可以从队列的尾部插入元素
 *   linkedDeque.put(new TempObject(4));
 *   linkedDeque.put(new TempObject(5));
 *   // pollLast , 可以从队列尾部取出元素
 *   tempObject = linkedDeque.pollLast();
 *   // 这里会打印 tempObject.index = 5
 *   System.out.println("tempObject.index = " + tempObject.getIndex());
 * 4、PriorityBlockingQueue是一个按照优先级进行内部元素排序的无限队列。存放在PriorityBlockingQueue中的元素必须实现Comparable接口，这样才能通过实现compareTo()方法进行排序。
 *   PriorityBlockingQueue不会保证优先级一样的元素的排序，也不保证当前队列中除了优先级最高的元素以外的元素，随时处于正确排序的位置。
 *   PriorityBlockingQueue<TempObject> priorityQueue = new PriorityBlockingQueue<TempObject>();
 *   priorityQueue.put(new TempObject(-5));
 *   priorityQueue.put(new TempObject(5));
 *   priorityQueue.put(new TempObject(-1));
 *   priorityQueue.put(new TempObject(1));
 *
 *   // 第一个元素是5
 *   // 实际上在还没有执行priorityQueue.poll()语句的时候，队列中的第二个元素不一定是1
 *   TempObject targetTempObject = priorityQueue.poll();
 *   System.out.println("tempObject.index = " + targetTempObject.getIndex());
 *   // 第二个元素是1
 *   targetTempObject = priorityQueue.poll();
 *   System.out.println("tempObject.index = " + targetTempObject.getIndex());
 *   // 第三个元素是-1
 *   targetTempObject = priorityQueue.poll();
 *   System.out.println("tempObject.index = " + targetTempObject.getIndex());
 *   // 第四个元素是-5
 *   targetTempObject = priorityQueue.poll();
 *   System.out.println("tempObject.index = " + targetTempObject.getIndex());
 *   ============================================================================
 *   // 这个元素类，必须实现Comparable接口
 *   private static class TempObject implements Comparable<TempObject> {
 *      private int index;
 *
 *      public TempObject(int index) {
 *         this.index = index;
 *      }
 *
 *     public int getIndex() {
 *          return index;
 *      }
 *
 *     @Override
 *     public int compareTo(TempObject o) {
 *          return o.getIndex() - this.index;
 *     }
 *
 *   }
 * 5、LinkedTransferQueue也是一个无限队列，它除了具有一般队列的操作特性外（先进先出），还具有一个阻塞特性：
 * LinkedTransferQueue可以由一对生产者/消费者线程进行操作，当消费者将一个新的元素插入队列后，消费者线程将会一直等待，
 * 直到某一个消费者线程将这个元素取走，反之亦然。
 *
 * RejectedExecutionHandler：制定一个拒绝任务处理器接口
 * 在创建ThreadPoolExecutor线程池时，一定会指定RejectedExecutionHandler接口的实现。
 * 如果您调用的是不需要指定RejectedExecutionHandler接口的构造函数，会使用一个默认的RejectedExecutionHandler接口实现AbortPolicy
 * 1、AbortPolicy：
 *  这个处理器，在任务被拒绝后会创建一个RejectedExecutionException异常并抛出。
 *  这个处理过程也是ThreadPoolExecutor线程池默认的RejectedExecutionHandler实现
 *  2、CallerRunsPolicy：
 *  这个拒绝处理器，将直接运行这个任务的run方法。但是，请注意并不是在ThreadPoolExecutor线程池中的线程中运行，
 *  而是直接调用这个任务实现的run方法。
 *  3、DiscardPolicy：
 *  丢弃处理器，将会默默丢弃这个被拒绝的任务，不会抛出异常，也不会通过其他方式执行这个任务的任何一个方法，更不会出现任何的日志提示。
 *  4、DiscardOldestPolicy：
 *  这个处理器很有意思。它会检查当前ThreadPoolExecutor线程池的等待队列。并调用队列的poll()方法，将当前处于等待队列列头的等待任务强行取出，然后再试图将当前被拒绝的任务提交到线程池执行
 *
 *  实际上查阅这四种ThreadPoolExecutor线程池自带的拒绝处理器实现，您可以发现CallerRunsPolicy、DiscardPolicy、DiscardOldestPolicy处理器针对被拒绝的任务并不是一个很好的处理方式。
 *  CallerRunsPolicy在非线程池以外直接调用任务的run方法，可能会造成线程安全上的问题；
 *  DiscardPolicy默默的忽略掉被拒绝任务，也没有输出日志或者提示，开发人员不会知道线程池的处理过程出现了错误；
 *  DiscardOldestPolicy中e.getQueue().poll()的方式好像是科学的，但是如果等待队列出现了容量问题，
 *  大多数情况下就是这个线程池的代码出现了BUG。
 *  最科学的的还是AbortPolicy提供的处理方式：抛出异常，由开发人员进行处理。
 *
 *
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/7 14:02
 */
public class ThreadPoolExecutorLearning {

    @Test
    public void start () throws InterruptedException {
        /*

         *
         * */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 1,
                TimeUnit.MINUTES, new SynchronousQueue<Runnable>());

        /*
          public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)
         *
         */

        for(int index = 0 ; index < 10 ; index ++) {
            poolExecutor.submit(new ThreadPoolExecutorLearning.TestRunnable(index));
        }

        // 没有特殊含义，只是为了保证main线程不会退出
        synchronized (poolExecutor) {
            poolExecutor.wait();
        }
    }


    /**
     * 这个就是测试用的线程
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
             * 等待60秒钟的事件，以便模拟业务操作过程
             * */
            Thread currentThread  = Thread.currentThread();
            System.out.println("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）开始执行===");
            synchronized (currentThread) {
                try {
                    currentThread.wait(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）执行完成");
        }

    }
}
