package com.mindasoft._06_thread.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 在大多数情况下您使用sycnchronized关键字或者使用ReentrantLock方式，
 * 都没有问题（这是因为90%的情况下，sycnchronized并不会真正的阻塞）。
 * 完全没有必要为了使用性能更好的ReentrantLock方式，而改变您历史代码版本中的sycnchronized关键字。
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/8 13:58
 */
public class ReadWriteReentrantLockLearning {

    public static void main(String[] args) throws RuntimeException {
        new ReadWriteReentrantLockLearning().test();
    }

    public void test() {
        final ReentrantReadWriteLock objectLock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread() {
            public void run() {
                ReentrantReadWriteLock.WriteLock writeLock = objectLock.writeLock();
                writeLock.lock();
                System.out.println("做了一些写操作的事情。。。。");
                writeLock.unlock();
            }
        };


        Thread thread2 = new Thread() {
            public void run() {
                ReentrantReadWriteLock.WriteLock writeLock = objectLock.writeLock();
                writeLock.lock();
                System.out.println("做了另一些写操作的事情。。。。");
                writeLock.unlock();
            }
        };

        Thread thread3 = new Thread() {
            public void run() {
                ReentrantReadWriteLock.ReadLock readLock = objectLock.readLock();
                readLock.lock();
                System.out.println("做了一些读操作的事情。。。。");
                readLock.unlock();
            }
        };

        //thread1、thread2、thread3在运行过程中，将按照我们之前描述的规律，相互作用
        thread1.start();
        thread2.start();
        // 您可以使用thread1.interrupt()指令对ReentrantLock的影像。
        // 您可以发现，thread1在加锁后并不会抛出interruptException异常
        // 至少在我们这种使用方式下，不会抛出异常
        // thread1.interrupt();
        thread3.start();
    }
}
