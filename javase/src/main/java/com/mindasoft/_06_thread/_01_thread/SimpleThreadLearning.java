package com.mindasoft._06_thread._01_thread;

/**
 * 
 * @author huangmin
 *
 */
public class SimpleThreadLearning extends Thread{
	
	private String name; 
	
	public SimpleThreadLearning(String name){
		this.name = name; 
		super.setName("SimpleThreadLearning");
	}
    
	@Override
	public void run() {
		int i = 1;
		while(i<100){
			System.out.println(name + ": "+i);
			i++;
			if(i ==50){
//				throw new RuntimeException("dddd");
			}
		}
	}
	
	public static void main(String[] args) {
		new SimpleThreadLearning("线程1").start();
		new SimpleThreadLearning("线程2").start();
	}
	
	
}