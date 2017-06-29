package com.ullas.java8;

public class SimpleLamdaExpDemo {

	public static void main(String args[]) {
		MyLamda blkOfCode = (int a, int b) -> {
			return a + b;
		};
		int res = blkOfCode.add(23, 47);
		System.out.println(res);
		MyLamda annonInner = new MyLamda() {
			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		res = blkOfCode.add(54, 5464);
		System.out.println(res);
		Thread t= new Thread(() -> System.out.println("Inside Therad"));
		t.run();
	}

}

interface MyLamda {
	int add(int a, int b);
}