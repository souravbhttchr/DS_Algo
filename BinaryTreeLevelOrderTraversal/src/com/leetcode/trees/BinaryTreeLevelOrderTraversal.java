package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		return traverse(root, 0, new ArrayList<List<Integer>>());
	}

	private List<List<Integer>> traverse(TreeNode root, int level, ArrayList<List<Integer>> traversal) {
		if (root != null) {
			if (traversal.size() <= level) {
				traversal.add(new ArrayList<>());
			}
			traversal.get(level).add(root.val);
			traverse(root.left, level + 1, traversal);
			traverse(root.right, level + 1, traversal);
		}
		return traversal;
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