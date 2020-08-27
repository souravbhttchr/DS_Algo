package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Foursome {

	public static void main(String[] args) {
		int[] nums = { 0,0,0,0 };
		int target = 0;
		System.out.println(new Foursome().fourSum(nums, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums != null && nums.length > 3) {
			Arrays.sort(nums);
			Set<List<Integer>> uniqueSet = new HashSet<>();
			for (int i = 0; i < nums.length - 3; i++) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					int left = j + 1;
					int right = nums.length - 1;
					while (left < right) {
						int sum = nums[i] + nums[j] + nums[left] + nums[right];
						if (sum > target) {
							right--;
						}
						if (sum < target) {
							left++;
						}
						if (sum == target) {
							List<Integer> sol = new ArrayList<>();
							sol.add(nums[i]);
							sol.add(nums[j]);
							sol.add(nums[left]);
							sol.add(nums[right]);
							uniqueSet.add(sol);
							left++;
							right--;
						}
					}
				}
			}
			ans.addAll(uniqueSet);
		}
		return ans;
	}
}
