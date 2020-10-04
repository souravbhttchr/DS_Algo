package com.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DaysTillNextWarmerDay {

	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		Arrays.stream(new DaysTillNextWarmerDay().dailyTemperatures(T))
				.forEach(d -> System.out.print(d + " "));
	}

	public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0) {
			return new int[0];
		}
		if (T.length == 1) {
			int[] res = new int[1];
			res[0] = 0;
			return res;
		}
		Stack<Integer> mStack = new Stack<>();
		int[] res = new int[T.length];

		for (int i = 0; i < T.length; i++) {
			if (mStack.isEmpty()) {
				mStack.push(i);
			} else {
				while (!mStack.isEmpty() && T[i] > T[mStack.peek()]) {
					res[mStack.peek()] = i - mStack.pop();
				}
				mStack.push(i);
			}
		}
		return res;
	}
}
