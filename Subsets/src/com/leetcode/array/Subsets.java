package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

	Set<List<Integer>> subSet;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Subsets().subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		List<Integer> withVal = new ArrayList<>();
		withVal.add(nums[0]);
		List<Integer> withoutVal = new ArrayList<>();
		findSubsets(nums, 1, withVal);
		findSubsets(nums, 1, withoutVal);
		List<List<Integer>> result = new ArrayList<>();
		result.addAll(subSet);
		return result;
	}

	private Set<List<Integer>> findSubsets(int[] nums, int index, List<Integer> list) {
		if (subSet == null) {
			subSet = new HashSet<>();
		}
		subSet.add(list);
		if (index < nums.length) {
			List<Integer> list3 = new ArrayList<>();
			List<Integer> list4 = new ArrayList<>();
			list3.addAll(list);
			list3.add(nums[index]);
			findSubsets(nums, index + 1, list3);
			findSubsets(nums, index + 1, list4);
		}
		return subSet;
	}
}
