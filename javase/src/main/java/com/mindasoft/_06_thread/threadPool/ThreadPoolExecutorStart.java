package com.mindasoft._06_thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/7 14:02
 */
public class ThreadPoolExecutorStart {

    public void start (){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
    }
}
