package com.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMin_N {
	public static void main(String[] args) {
		int[] A = { 71, 55, 82, 55 };
		System.out.println(new SumOfSubArrayMin_N().sumSubarrayMins(A));
	}

	public int sumSubarrayMins(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		return findSubArrays(A);
	}

	private int findSubArrays(int[] a) {
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);

		Stack<Integer> cStack = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (!cStack.isEmpty()) {
				while (!cStack.isEmpty()) {
					if (a[cStack.peek()] > a[i]) {
						left[i] += left[cStack.pop()];
						continue;
					} else if (a[cStack.peek()] < a[i]) {
						cStack.push(i);
						break;
					} else {
						break;
					}
				}
				if (cStack.isEmpty()) {
					cStack.push(i);
				}
			} else if (cStack.isEmpty()) {
				cStack.push(i);
			}
		}

		cStack.clear();

		for (int i = a.length - 1; i >= 0; i--) {
			if (!cStack.isEmpty()) {
				while (!cStack.isEmpty()) {
					if (a[cStack.peek()] > a[i]) {
						right[i] += right[cStack.pop()];
						continue;
					} else if (a[cStack.peek()] < a[i]) {
						cStack.push(i);
						break;
					} else {
						break;
					}
				}
				if (cStack.isEmpty()) {
					cStack.push(i);
				}
			} else if (cStack.isEmpty()) {
				cStack.push(i);
			}
		}
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i] * left[i] * right[i];
		}

		return sum;
	}
}
