package com.mindasoft.thread;

public class SimpleRunableDemo implements Runnable{

	private String name; 

    public SimpleRunableDemo(String name) { 
        this.name = name; 
    } 

    public void run() { 
        for (int i = 0; i < 5; i++) { 
            for (long k = 0; k < 10000000; k++) ; 
            System.out.println(name + ": " + i); 
        } 
    } 
    
	public static void main(String[] args) {
		new Thread(new SimpleRunableDemo("线程1")).start();
		new Thread(new SimpleRunableDemo("线程2")).start();
	}

}
