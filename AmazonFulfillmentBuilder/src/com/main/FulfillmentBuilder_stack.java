package com.main;

import java.util.PriorityQueue;
import java.util.Stack;

public class FulfillmentBuilder_stack {

	public static void main(String[] args) {
		int[] parts = { 1, 2, 3, 4 };
		System.out.println(optimalTime(parts));
	}

	private static int optimalTime(int[] parts) {
		if (parts == null || parts.length == 1) {
			return 0;
		}

		Stack<Integer> mStack = new Stack<>();

		for (int size : parts) {
			stackify(mStack, size);
		}

		int time = 0;

		while (!mStack.isEmpty()) {
			int smallest1 = mStack.pop();
			int smallest2 = mStack.pop();
			int timeTaken = smallest1 + smallest2;
			if (!mStack.isEmpty()) {
				stackify(mStack, timeTaken);
			}
			time += timeTaken;
		}

		return time;
	}

	private static void stackify(Stack<Integer> mStack, int size) {
		if (mStack.isEmpty()) {
			mStack.push(size);
		} else if (mStack.peek() < size) {
			int index = mStack.size() - 1;
			while (index >= 0 && mStack.get(index) < size) {
				index = index - 1;
			}
			mStack.add(index + 1, size);
		} else if (mStack.peek() >= size) {
			mStack.push(size);
		}
	}

}
