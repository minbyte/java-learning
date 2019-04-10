package com.mindasoft._06_thread.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 * CountDownLatch 类位于 java.util.concurrent 包下，利用它可以实现类似计数器的功能。比如有一个任务 A，它要等待其他
 * 4 个任务执行完毕之后才能执行，此时就可以利用 CountDownLatch 来实现这种功能了。
 * @author: min
 * @date: 2019/4/10 11:16
 * @version: 1.0.0
 */
public class SemaphoreLearning {

    private static int threadCount = 200;
    private static int clientTotal = 5000;
    private static int count = 0;

    //本例中，先搞了一堆线程（用线程池搞的），然后使用 Semaphore 控制最多允许 200 个线程同时执行。同时， main 方法
    //使用 CountDownLatch.await()进行阻塞，直到 for 循环执行完毕。最后关闭线程池、打印 count。
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        add();
                        semaphore.release();
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count = " +  count);
    }

    private static void add() {
        count++;
    }
}
