package com.leetcode.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveKDigits {

	int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		String num = "132";
		int k = 1;
		System.out.println(new RemoveKDigits().removeKdigits(num, k));
	}

	public String removeKdigits(String num, int k) {
		if (k == 0) {
			return num;
		}
		if (num == null || num.length() == 0) {
			return "";
		}
		if (num != null && num.length() == k) {
			return "0";
		}

		Set<List<Integer>> table = new HashSet<>();
		return removeDigits(num, 0, k, table);
	}

	private String removeDigits(String num, int index, int k, Set<List<Integer>> table) {
		List<Integer> list = new ArrayList<>();
		list.add(Integer.parseInt(num));
		list.add(index);
		if (!table.contains(list)) {
			table.add(list);
			if (k == 0) {
				min = Math.min(min, Integer.parseInt(num));
				return Integer.toString(min);
			}
			for (int j = index; j < num.length(); j++) {
				String numRemoved = new StringBuilder(num).deleteCharAt(j).toString();
				removeDigits(num, index + 1, k, table);
				removeDigits(numRemoved, index, k - 1, table);
			}
		}
		return Integer.toString(min);
	}
}
