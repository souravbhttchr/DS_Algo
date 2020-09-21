package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfRepeatedSubArray {

	int length = 0;
	int start = 0;

	public static void main(String[] args) {
		int A[] = { 0, 0, 0, 0, 1 };
		int B[] = { 1, 0, 0, 0, 0 };
		System.out.println(new MaxLengthOfRepeatedSubArray().findLength(A, B));
	}

	public int findLength(int[] A, int[] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0) {
			return 0;
		}
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		findSubArray(A, 0, list, res, true);
		length = 0;
		start = 0;
		length = findSubArray(B, 0, list, res, false);
		return length;
	}

	private int findSubArray(int[] arr, int pos, List<Integer> list, Set<List<Integer>> res, boolean isToAdd) {
		List<Integer> listToAdd = new ArrayList<>(list);
		if (!res.contains(listToAdd)) {
			if (isToAdd)
				res.add(new ArrayList<>(list));
		} else {
			length = Math.max(length, listToAdd.size());
		}
		for (int i = pos; i < arr.length; i++) {
			list.add(arr[i]);
			findSubArray(arr, pos + 1, list, res, isToAdd);
			if (start < arr.length) {
				list.clear();
				pos = start + 1;
				i = start++;
			} else {
				break;
			}
		}

		return length;
	}
}
