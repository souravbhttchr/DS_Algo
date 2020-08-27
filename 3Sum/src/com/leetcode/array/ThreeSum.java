package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, -2, -1 };
		System.out.println(new ThreeSum().threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums != null && nums.length > 2) {
			Set<List<Integer>> uniqueSet = new HashSet<>();
			Arrays.sort(nums);
			for (int i = 0; i < nums.length-2; i++) {
				int left = i+1;
				int right = nums.length-1;
				while (right > left) {
					if(nums[i] + nums[left] + nums[right] == 0) {
						List<Integer> sol = new ArrayList<>();
						sol.add(nums[i]);
						sol.add(nums[left]);
						sol.add(nums[right]);
						uniqueSet.add(sol);
						left++;
						right--;
					} else if(nums[i] + nums[left] + nums[right] > 0) {
						right --;
					} else {
						left ++;
					}
				}
			}
			ans.addAll(uniqueSet);
		}
		return ans;
	}
}
