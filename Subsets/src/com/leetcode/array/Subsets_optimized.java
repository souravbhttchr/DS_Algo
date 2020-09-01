package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Subsets_optimized {

	Set<List<Integer>> subSet;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Subsets_optimized().subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		backtrack(nums, 0, list, result);
		return result;
	}

	private void backtrack(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(list));
		for (int i = pos; i < nums.length; i++) {
			list.add(nums[i]);
			backtrack(nums, i + 1, list, result);
			list.remove(list.size() - 1);
		}
	}
}
