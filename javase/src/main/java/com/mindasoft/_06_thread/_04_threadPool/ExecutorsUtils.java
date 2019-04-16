package com.mindasoft._06_thread._04_threadPool;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Executors是一个用于创建各种线程池特性的工具类。通常情况下，您使用这个工具类创建的线程池就可以涵盖90%以上的业务场景了。
 * submit有返回值，而execute没有
 *
 *  ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
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

	public static void shutdownAndAwaitTermination(ExecutorService pool) {
		pool.shutdown(); // Disable new tasks from being submitted
		try {
			// Wait a while for existing tasks to terminate
			if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
				pool.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!pool.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			pool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}

	@Test
	public void cachedThreadPool(){
		ExecutorService executorService = Executors.newCachedThreadPool();
	}

	@Test
	public void fixedThreadPool(){
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		CompletionService  completionService = new ExecutorCompletionService<String>(executorService);

		Random random = new Random();

		try {
			int taskNum = 4;
			for(int i = 0; i < taskNum; i ++) {
				Task task = new Task(random.nextInt(20), String.valueOf(i + 1));
				completionService.submit(task);
			}
			for(int i = 0; i < taskNum; i ++) {
				String result = (String) completionService.take().get();
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error");
		}
	}


	class Task implements Callable<String> {

		private int sleepSec;
		private String name;

		public Task(int sleepSec,  String name) {
			this.sleepSec = sleepSec;
			this.name = name;
		}

		public String call() throws Exception {
			Thread.sleep(sleepSec * 1000);
			return "任务" + name + "执行完成";
		}

	}
}
