package com.leetcode.trees;

import java.util.ArrayList;

public class KthSmallestBST {

	int kth;
	boolean found;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		int k = 1;
		System.out.println(new KthSmallestBST().kthSmallest(root, k));
	}

	public int kthSmallest(TreeNode root, int k) {
		if (root == null || k == 0) {
			return 0;
		}
		return findKthSmallest(root, k, new ArrayList<Integer>());
	}

	private int findKthSmallest(TreeNode root, int k, ArrayList<Integer> list) {
		if (list.size() == k) {
			kth = list.get(list.size() - 1);
			found = true;
		}
		if (root != null) {
			if (!found) {
				findKthSmallest(root.left, k, list);
				list.add(root.val);
				findKthSmallest(root.right, k, list);
			}
		}
		return kth;
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