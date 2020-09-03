package com.leetcode.array;

import java.util.Arrays;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(new FindDuplicateNumber().findDuplicate(nums));
	}

	public int findDuplicate(int[] nums) {
		if(nums.length == 2) return nums[0];
		Arrays.sort(nums);
		int val = 0;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				val = nums[i];
				break;
			}
		}
		
		return val;
	}
}
