package com.ullas.java.AbstractClass;

abstract public class AbstarctClassExample {
	public int i;
	public int j;
	public AbstarctClassExample(int i, int j) {
		super();
		this.i = i;
		this.j = j;
		System.out.println("Abstract Class Details:  "+this.i+"  --  "+this.j);
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	

}
