package com.mindasoft._06_thread._12_scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 　　ScheduledExecutorService的主要作用就是可以将定时任务与线程池功能结合使用。
 * @author: min
 * @date: 2019/4/10 10:26
 * @version: 1.0.0
 */
public class ScheduledExecutorServiceLearning {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // 每隔多少时间，固定执行任务。
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1"+ System.currentTimeMillis());
            }
        }, 0, 100, TimeUnit.MILLISECONDS);

        // 前一个任务结束的时刻，开始计算间隔时间，再开始执行任务
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("run 2"+ System.currentTimeMillis());
            }
        }, 0, 100, TimeUnit.MILLISECONDS);

        // 延迟执行
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("run 3"+ System.currentTimeMillis());
            }
        }, 100, TimeUnit.MILLISECONDS);
    }
}
