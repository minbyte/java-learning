package com.mindasoft.thread;

/**
 * 
 * @author huangmin
 *
 */
public class SimpleThreadDemo extends Thread{
	
	private String name; 
	
	public SimpleThreadDemo(String name){
		this.name = name; 
		super.setName("SimpleThreadDemo");
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
		new SimpleThreadDemo("线程1").start();
		new SimpleThreadDemo("线程2").start();
	}
	
	
}