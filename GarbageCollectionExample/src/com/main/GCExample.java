package com.main;

public class GCExample {

	public static void main(String[] args) {
		A a = new A("Blue");
		a = null;

		for (int i = 0; i < 2; i++) {
			System.gc();
		}
	}
}

class A {
	private String color;

	public A(String color) {
		super();
		this.color = color;
	}

	public void finalize() {
		System.out.println(color + " Cleaned");
	}
}