package com.ullas.java.multithreading;

import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String args[]) throws InterruptedException {
		final ProdCon pc = new ProdCon();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

	public static class ProdCon {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 5;

		public void produce() throws InterruptedException {
			int val = 0;
			while (true) {
				synchronized (this) {
					while (list.size() == capacity)
						wait();

					System.out.println("Procer Produced: " + val);
					list.add(val++);
					notify();
					Thread.sleep(1000);

				}

			}
		}

		public void consume() throws InterruptedException {
			while(true){
				synchronized(this)
				{
					while(list.size()==0)
						wait();
					int val=list.removeFirst();
					System.out.println("Consumer consumed: "+val);
					notify();
					Thread.sleep(1000);
				}
			}

		}
	}
}