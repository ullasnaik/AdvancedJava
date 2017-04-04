package com.ullas.java;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleThread obj = new SimpleThread();
		Thread t = new Thread(obj);
		Thread t1 = new Thread(obj);
		t.setPriority(10);

		t.start();
		t1.start();

	}

}
