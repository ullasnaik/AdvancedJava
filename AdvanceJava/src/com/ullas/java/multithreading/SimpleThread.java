package com.ullas.java.multithreading;

public class SimpleThread implements Runnable{


	public void run() {
		for (int i=0;i<1000;i++)
		System.out.println(Thread.currentThread().getName()+"----------"+i+"-----------");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
