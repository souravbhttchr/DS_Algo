package com.leetcode.tree;

public class MaxHeightOfTree {

	int maxHeight = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4, null, null)), new TreeNode(6));
		System.out.println(new MaxHeightOfTree().maxHeight(root));
	}

	public int maxHeight(TreeNode root) {
		if(root == null) {
			return maxHeight;
		}
		return findMaxHeight(root, 1);
	}

	private int findMaxHeight(TreeNode root, int height) {
		maxHeight = Math.max(maxHeight, height);
		
		if(root.left != null) {
			findMaxHeight(root.left, height+1);
		}
		if(root.right != null) {
			findMaxHeight(root.right, height+1);
		}
		return maxHeight;
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