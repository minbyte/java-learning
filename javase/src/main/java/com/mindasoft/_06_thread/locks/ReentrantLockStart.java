package com.mindasoft._06_thread.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/8 14:01
 */
public class ReentrantLockStart {

    public void test() {
        final ReentrantLock objectLock = new ReentrantLock();

        new Thread() {
            public void run() {
                objectLock.lock();
                System.out.println("做了一些事情。。。。");
                objectLock.unlock();
            }
        }.start();

        new Thread() {
            public void run() {
                objectLock.lock();
                System.out.println("做了另一些事情。。。。");
                objectLock.unlock();
            }
        }.start();
    }
}
