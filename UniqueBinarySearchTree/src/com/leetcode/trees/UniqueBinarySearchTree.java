package com.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTree {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(new UniqueBinarySearchTree().numTrees(n));
	}

	public int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		Map<Integer, Integer> bstMap = new HashMap<>();
		bstMap.put(0, 1);
		bstMap.put(1, 1);
		bstMap.put(2, 2);

		return count(n, bstMap);
	}

	private int count(int n, Map<Integer, Integer> bstMap) {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			int left = i - 1;
			int right = n - i;
			if (!bstMap.containsKey(left)) {
				bstMap.put(left, count(left, bstMap));
			}
			if (!bstMap.containsKey(right)) {
				bstMap.put(right, count(right, bstMap));
			}
			num += bstMap.get(left) * bstMap.get(right);
		}
		bstMap.put(n, num);
		return bstMap.get(n);
	}
}
