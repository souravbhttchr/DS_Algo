package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class LongestUnivalueLength {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4, null, new TreeNode(4))),
				new TreeNode(5, null, new TreeNode(5)));
		
		System.out.println(new LongestUnivalueLength().longestUnivalueLength(root));
	}

	public int longestUnivalueLength(TreeNode root) {
		if(root == null) {
			return 0;
		}

		List<Integer> lengths = findLongestLength(root, root.val, 1, new ArrayList<Integer>());
		int maxLength = 0;
		for (Integer integer : lengths) {
			maxLength = Math.max(maxLength, integer);
		}
		return maxLength;
	}

	private List<Integer> findLongestLength(TreeNode root, int val, int length, ArrayList<Integer> lengths) {
		if(root.left != null && root.left.val != root.val && root.right != null && root.right.val != root.val) {
			lengths.add(length);
			findLongestLength(root.left, root.left.val, 1, lengths);
			findLongestLength(root.right, root.right.val, 1, lengths);
		}
		
		if(root.left != null && root.left.val == root.val) {
			findLongestLength(root.left, root.left.val, length+1, lengths);
		}
		
		if(root.right != null && root.right.val == root.val) {
			findLongestLength(root.right, root.right.val, length+1, lengths);
		}
		
		if(root.left == null && root.right == null) {
			lengths.add(length);
		}
		
		return lengths;
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