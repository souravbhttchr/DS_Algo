package com.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(new UniqueBinarySearchTrees2().generateTrees(n));
	}

	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return Collections.emptyList();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int s, int e) {
		List<TreeNode> res = new ArrayList<>();
		if (s > e) {
			res.add(null);
			return res;
		}
		for (int i = s; i <= e; ++i) {
			List<TreeNode> l = helper(s, i - 1);
			List<TreeNode> r = helper(i + 1, e);
			for (TreeNode nl : l) {
				for (TreeNode nr : r) {
					res.add(new TreeNode(i, nl, nr));
				}
			}
		}
		return res;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}