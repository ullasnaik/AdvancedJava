package com.ullas.java.main;

import java.io.FileNotFoundException;
import java.util.jar.Attributes.Name;

import com.ullas.java.AbstractClass.AbstarctClassExample;

public class AbstarctClassTest extends AbstarctClassExample {

	public AbstarctClassTest(int i,int j) {
		super(i, i);
	}

	public static void main(String[] args) throws InterruptedException, ArithmeticException {
		// TODO Auto-generated method stub

		AbstarctClassExample name = new AbstarctClassTest(1,2);
	}

}
