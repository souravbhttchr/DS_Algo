package com.leetcode.array;

public class LIS_Onlogn {

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(new LIS_Onlogn().lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] ends = new int[nums.length];
		ends[0] = nums[0];
		int end_index = 0;
		int left = 0, right = 0, mid = 0;

		for (int i = 1; i < nums.length; i++) {
			left = 0;
			right = end_index;
			while (left <= right) {
				mid = left + ((right - left) >> 1);
				if (nums[i] > ends[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
			end_index = Math.max(left, end_index);
			ends[left] = nums[i];
		}
		return end_index + 1;
	}
}
