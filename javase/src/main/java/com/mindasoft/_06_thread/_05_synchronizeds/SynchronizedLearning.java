package com.mindasoft._06_thread._05_synchronizeds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作⽤域
 * 1. 修饰代码块：大括号括起来的代码，作用于调用的对象
 * 2. 修饰方法：整个方法，作用于调用的对象
 * 3. 修饰静态方法：整个静态方法，作用于所有对象
 * 4. 修饰类：括号括起来的部分，作用于所有对象
 * @author: min
 * @date: 2019/4/10 11:32
 * @version: 1.0.0
 */
public class SynchronizedLearning {

    void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        }
    }

    synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }

    static synchronized void test3() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }

    void test4() {
        synchronized (SynchronizedLearning.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedLearning test = new SynchronizedLearning();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 第一个线程执行
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                test.test1();
            }
        });
        // 第二个线程执行
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                test.test1();
            }
        });
    }
}
