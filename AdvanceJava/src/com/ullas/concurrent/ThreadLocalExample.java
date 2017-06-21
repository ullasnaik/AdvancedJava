package com.ullas.concurrent;

public class ThreadLocalExample {
	
	public static class Mythread implements Runnable{
		ThreadLocal<Integer> localvar= new ThreadLocal<>();
		@Override
		public void run(){
			localvar.set((int)(Math.random()*1000));
			System.out.println(localvar.get());
		}
	}
	public static void main (String args[]) throws InterruptedException{
		Mythread t= new Mythread();
		Thread t1= new Thread(t);
		Thread t2= new Thread(t);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}

}
