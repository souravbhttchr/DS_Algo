package com.leetcode.trees;

public class HouseRobber3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)),
				new TreeNode(5, null, new TreeNode(1)));
		System.out.println(new HouseRobber3().rob(root));
	}

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int rob1 = 0;
		int rob2 = 0;

		rob1 = root.val + (root.left != null ? rob(root.left.left) : 0) + (root.left != null ? rob(root.left.right) : 0)
				+ (root.right != null ? rob(root.right.left) : 0) + (root.right != null ? rob(root.right.right) : 0);
		rob2 = rob(root.left) + rob(root.right);
		
		return Math.max(rob1, rob2);
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