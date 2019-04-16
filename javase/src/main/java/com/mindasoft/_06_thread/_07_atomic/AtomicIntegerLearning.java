package com.mindasoft._06_thread._07_atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic原理
 * unsafe.compareAndSwapInt(currentValue, valueOffset, expect, update);
 * 使用 CAS。核心方法有 compareAndSet 等， 该方法主要调用 unsafe.compareAndSwapInt 这个方法。
 * 该方法有四个参数，其中第一个参数为需要改变的对象，第二个为偏移量(即之前求出来的 valueOffset 的值)，第三个参数为期待的值，第四个为更新后的值。
 * 整个方法的作用即：如果调用该方法时， currentValue 的值与 expect 这个值相等，那么则将 currentValue 修改为 update 这个值，并返
 * 回一个 true， 否则不做任何操作，并返回一个 false。
 *
 * Atomic 类中，getAndAddInt 大量用到了 do…while…语句，在竞争不激烈的情况下， CAS 成功率比较高，但如果竞争比较激烈，那么失败率就会增
 * 加，从而影响性能。
 *
 * @author: min
 * @date: 2019/4/10 11:19
 * @version: 1.0.0
 */
public class AtomicIntegerLearning {

    private static int threadCount = 200;
    private static int clientTotal = 5000;
    private static AtomicInteger count = new AtomicInteger(0);

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
                        count.incrementAndGet();
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
}
