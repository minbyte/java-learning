package com.mindasoft._06_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo implements Callable<String> {

	private String name; 
	
	public CallableDemo(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 10; i++) { 
			for (long k = 0; k < 10000000; k++) ; 
            System.out.println(name + ": " + i); 
        } 
		
		return name + "返回结果!" ;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool =  Executors.newFixedThreadPool(3);
		Future<String> f1 = pool.submit(new CallableDemo("线程1"));
		System.out.println(f1.get());//get会等待线程执行完毕  阻塞性方法
		
		Future<String> f2 = pool.submit(new CallableDemo("线程2"));
		Future<String> f3 = pool.submit(new CallableDemo("线程3"));
		CallableDemo.shutdownAndAwaitTermination(pool);
		System.out.println(f2.get());
		System.out.println(f3.get());
	}
	
	/**
	 * 等待所有任务执行完毕后，再执行主线程
	 * @param pool
	 */
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

}
