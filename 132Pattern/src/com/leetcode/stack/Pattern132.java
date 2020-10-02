package com.leetcode.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pattern132 {

	boolean res;

	public static void main(String[] args) {
		int[] nums = { 3, 5, 0, 3, 4 };
		System.out.println(new Pattern132().find132pattern(nums));
	}

	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}

		return findPattern(nums, 0, 0, null, new HashSet<List<Integer>>());
	}

	private boolean findPattern(int[] nums, int index, int count, List<Integer> list, Set<List<Integer>> table) {
		if (list != null) {
			table.add(new ArrayList<>(list));
		}
		if (count == 3) {
			res = true;
		}
		if (index < nums.length) {
			if (count == 0) {
				list = new ArrayList<>();
				findPattern(nums, index + 1, count, list, table);
				list.add(nums[index]);
				if (!table.contains(list)) {
					findPattern(nums, index + 1, count + 1, list, table);
				}
			}
			if (count == 1) {
				if (nums[index] > list.get(0)) {
					findPattern(nums, index + 1, count, list, table);
					if (list.size() > count) {
						list = new ArrayList<>(list.subList(0, 1));
					}
					list.add(nums[index]);
					if (!table.contains(list)) {
						findPattern(nums, index + 1, count + 1, list, table);
					}
				}
				if (!table.contains(list)) {
					findPattern(nums, index + 1, count, list, table);
				}
			}
			if (count == 2) {
				if (nums[index] > list.get(0) && nums[index] < list.get(1)) {
					findPattern(nums, index + 1, count, list, table);
					if (list.size() > count) {
						list = new ArrayList<>(list.subList(0, 2));
					}
					list.add(nums[index]);
					if (!table.contains(list)) {
						findPattern(nums, index + 1, count + 1, list, table);
					}
				}
				if (!table.contains(list)) {
					findPattern(nums, index + 1, count, list, table);
				}
			}
		}
		return res;
	}
}
