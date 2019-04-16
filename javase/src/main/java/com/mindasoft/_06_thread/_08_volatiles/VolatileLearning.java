package com.mindasoft._06_thread._08_volatiles;

/**
 * 被volatile修饰的变量能够保证每个线程能够获取该变量的最新值，从而避免出现数据脏读的现象。
 * @author: min
 * @date: 2019/4/12 9:47
 * @version: 1.0.0
 */
public class VolatileLearning {

    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver){
                    System.out.println("子线程执行");
                }
                System.out.println("子线程结束");
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
        System.out.println("主线程执行");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");

    }
}
