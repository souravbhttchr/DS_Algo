package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubArrayMin_N2 {
	int sum = 0;
	int start = 0;
	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4 };
		System.out.println(new SumOfSubArrayMin_N2().sumSubarrayMins(A));
	}

	public int sumSubarrayMins(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		List<Integer> singleList = new ArrayList<>();
		findSubArrays(A, 0, singleList);
		return sum;
	}

	private void findSubArrays(int[] a, int pos, List<Integer> singleList) {
		if (!singleList.isEmpty()) {
			int min = Integer.MAX_VALUE;
			for (Integer integer : singleList) {
				min = Math.min(min, integer);
			}
			sum += min;
		}
		for (int i = pos; i < a.length; i++) {
			singleList.add(a[i]);
			findSubArrays(a, pos + 1, singleList);
			singleList.clear();
			if (start < a.length) {
				pos = start + 1;
				i = start++;
			} else {
				break;
			}
		}
	}
}
