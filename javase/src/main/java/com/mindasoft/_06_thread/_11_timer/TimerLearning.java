package com.mindasoft._06_thread._11_timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/12 16:52
 * @version: 1.0.0
 *
 *  延迟执行一次
 *  public void schedule(TimerTask task, long delay);
 *  public void schedule(TimerTask task, Date time);
 *
 *  // 前一次执行程序结束后 间隔时间，再执行任务
 *  public void schedule(TimerTask task, long delay, long period) ;
 *  public void schedule(TimerTask task, Date firstTime, long period) ;
 *
 * // 每隔多少时间，固定执行任务。
 *  public void scheduleAtFixedRate(TimerTask task, long delay, long period)
 *  public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
 */
public class TimerLearning {

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

        //前一次执行程序结束后 间隔2000ms 再开始执行下一次程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 0,2000);

        //每间隔2000ms后，执行一次程序
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        },0,2000);
    }
}
