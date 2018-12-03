package com.mindasoft._03_collection;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * @author: min
 * @date: 2018/12/3 15:14
 * @version: 1.0.0
 */
public class DelayQueueLearning {

    public static void main(String[] args) {
        // 创建延时队列
        DelayQueue<DelayEvent> queue = new DelayQueue<DelayEvent>();
        // 添加延时消息,m1 延时3s
        DelayEvent m1 = new DelayEvent(1, "world", 3000);
        // 添加延时消息,m2 延时10s
        DelayEvent m2 = new DelayEvent(2, "hello", 10000);
        //将延时消息放到延时队列中
        queue.offer(m2);
        queue.offer(m1);
        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        System.out.println( Instant.now());
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new DelayConsumer(queue));
        exec.shutdown();
    }

}

class DelayConsumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<DelayEvent> queue;

    public DelayConsumer(DelayQueue<DelayEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("这里阻塞等待" + Instant.now() + ",数量" +queue.size());
                DelayEvent take = queue.take();
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody() + Instant.now());
                if(1 == take.getId()){
                    DelayEvent m3 = new DelayEvent(3, "xixi", 1000);
                    System.out.println(Instant.now());
                    queue.offer(m3);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class DelayEvent implements Delayed {

    private int id;
    private String body; // 消息内容
    private long excuteTime;// 延迟时长，这个是必须的属性因为要按照这个判断延时时长。

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public long getExcuteTime() {
        return excuteTime;
    }

    public DelayEvent(int id, String body, long delayTime) {
        this.id = id;
        this.body = body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    // 自定义实现比较方法返回 1 0 -1三个参数
    @Override
    public int compareTo(Delayed delayed) {
        DelayEvent msg = (DelayEvent) delayed;
        return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1
                : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
    }

    // 延迟任务是否到时就是按照这个方法判断如果返回的是负数则说明到期否则还没到期
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}
