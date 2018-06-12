package com.mindasoft._06_thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/12 16:52
 * @version: 1.0.0
 *
 *  public void schedule(TimerTask task, long delay);
 *  public void schedule(TimerTask task, Date time);
 *
 */
public class TimerStart {

    public static void main(String[] args) {
        Timer timer = new Timer();

        //延迟1000ms执行程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 1000);


        //延迟10000ms执行程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, new Date(System.currentTimeMillis() + 10000));
    }
}
