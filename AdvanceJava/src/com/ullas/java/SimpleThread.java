package com.ullas.java;

public class SimpleThread implements Runnable{


	public void run() {
		System.out.println("Thread is running:"+Thread.currentThread().getName()+": Thread Priority:"+Thread.currentThread().getPriority());
		
	}

}
