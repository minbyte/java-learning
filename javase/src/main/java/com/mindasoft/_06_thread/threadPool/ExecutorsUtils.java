package com.mindasoft._06_thread.threadPool;

import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * Executors是一个用于创建各种线程池特性的工具类。通常情况下，您使用这个工具类创建的线程池就可以涵盖90%以上的业务场景了。
 * 1、创建一个固定大小的ThreadPoolExecutor线程池：
 *   public static ExecutorService newFixedThreadPool(int nThreads) {
 *       return new ThreadPoolExecutor(nThreads, nThreads,
 *       0L, TimeUnit.MILLISECONDS,
 *       new LinkedBlockingQueue<Runnable>());
 *   }
 *
 * 2、创建一个只有一个线程的ThreadPoolExecutor线程池：
 *   public static ExecutorService newSingleThreadExecutor() {
 *       return new FinalizableDelegatedExecutorService
 *       (new ThreadPoolExecutor(1, 1,
 *       0L, TimeUnit.MILLISECONDS,
 *       new LinkedBlockingQueue<Runnable>()));
 *   }
 *
 * 3、创建一个“Cache”线程池：
 *   public static ExecutorService newCachedThreadPool() {
 *       return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
 *       60L, TimeUnit.SECONDS,
 *       new SynchronousQueue<Runnable>());
 *   }
 *
 *
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/8 13:47
 */
public class ExecutorsUtils {

	@Test
	public void cachedThreadPool(){
		Executors.newCachedThreadPool();
	}


}
