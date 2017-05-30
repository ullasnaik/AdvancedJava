package com.ullas.java.multithreading;

public class CallbackSolution {

	public static void main(String[] args) {
		//new MyThread.start();
	}

	public void mymeth(String str) {
		System.out.println(str);
	}

}

class MyThread extends Thread {

	Callback callback;

	public MyThread(Callback callback) {
		this.callback = callback;
	}

	public void run() {
		callback.mymeth("Hello");
	}



}
 interface Callback {
	int mymeth(String s);
}