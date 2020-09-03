package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,3,2,1};
		System.out.println(new FindDuplicateInArray().findDuplicates(nums));
	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int n = nums.length;
		int[] myArr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			myArr[nums[i]]++;
		}
		for (int i = 0; i < n + 1; i++) {
			if (myArr[i] > 1)
				list.add(i);
		}
		return list;
	}
}
