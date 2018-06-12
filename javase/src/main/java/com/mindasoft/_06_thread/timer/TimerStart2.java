package com.mindasoft._06_thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/12 16:52
 * @version: 1.0.0
 *
 *  // 前一次执行程序结束后 执行
 *  // 在循环执行类别中根据循环时间间隔又可以分为两类
 *  public void schedule(TimerTask task, long delay, long period) ;
 *  public void schedule(TimerTask task, Date firstTime, long period) ;
 *
 * //前一次程序执行开始后 执行
 *  public void scheduleAtFixedRate(TimerTask task, long delay, long period)
 *  public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
 */
public class TimerStart2 {

    public static void main(String[] args) {
        Timer timer = new Timer();

        //前一次执行程序结束后 2000ms 后开始执行下一次程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 0,2000);

        //前一次程序执行开始 后 2000ms后开始执行下一次程序
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        },0,2000);
    }
}
