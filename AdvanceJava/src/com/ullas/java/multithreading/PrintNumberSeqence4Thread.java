package com.ullas.java.multithreading;

public class PrintNumberSeqence4Thread {

	public static int num = 0;

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();
		MyThread m1 = new MyThread(lock,0);
		MyThread m2 = new MyThread(lock,1);
		MyThread m3 = new MyThread(lock,2);
		MyThread m4 = new MyThread(lock,3);
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		Thread t4 = new Thread(m4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	static class MyThread implements Runnable {
		ResourceLock lock;
		public  static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		public MyThread(ResourceLock lock, Integer threadLocal) {
			super();
			this.lock = lock;
			MyThread.threadLocal.set(threadLocal);
		}


		public Integer getI() {
			return threadLocal.get();
		}

		public void setI(Integer i) {
			MyThread.threadLocal.set(i);
		}


		@Override
		public void run() {
			synchronized (lock) {
				while (true) {
					while (lock.flag != threadLocal.get())
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(Thread.currentThread().getName() + " : " + ++num);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.flag = (++lock.flag) % 4;
					lock.notifyAll();
				}
			}
		}
	}

	static class ResourceLock {
		public volatile int flag = 1;
	}
}
