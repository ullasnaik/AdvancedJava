package com.ullas.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	public static void main(String args[]) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3);
		Thread t1 = new Thread(new CyclicBarrierService(barrier));
		t1.setName("Thread1");
		Thread t2 = new Thread(new CyclicBarrierService(barrier));
		t1.setName("Thread2");
		Thread t3 = new Thread(new CyclicBarrierService(barrier));
		t1.setName("Thread3");
		t1.start();
		Thread.sleep(10000);
		t2.start();
		Thread.sleep(10000);
		t3.start();
		Thread.sleep(10000);
	}
}

class CyclicBarrierService implements Runnable {
	CyclicBarrier barrier;

	public CyclicBarrierService(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " Arrived");
			try{
				barrier.await();
			}catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Boarding..");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
