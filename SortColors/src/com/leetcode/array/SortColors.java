package com.leetcode.array;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 0, 1, 0 };
		new SortColors().sortColors(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	public void sortColors(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int low = 0, mid = 0, high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, low++, mid++);
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				swap(nums, mid, high--);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
