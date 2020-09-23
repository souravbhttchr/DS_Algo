package com.leetcode.stack;

class Driver{
	public static void main(String[] args) {
		MinStack min = new MinStack();
		min.push(512);
		min.push(-1024);
		min.push(-1024);
		min.push(512);
		min.pop();
		System.out.println(min.getMin());
		min.pop();
		System.out.println(min.getMin());
		min.pop();
		System.out.println(min.getMin());
	}
}