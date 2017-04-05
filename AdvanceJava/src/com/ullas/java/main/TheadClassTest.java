package com.ullas.java.main;

import com.ullas.java.multithreading.SimpleThread;

public class TheadClassTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		SimpleThread obj = new SimpleThread();
		SimpleThread obj1 = new SimpleThread();
		Thread t = new Thread(obj);
		Thread t1 = new Thread(obj1);
		t.setPriority(10);
		t.start();
		t1.start();
		t.join();

	}

}
