package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(8, new TreeNode(9), null))));
		System.out.println(new PostOrderTraversal().postorderTraversal(root));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		return findPostorderTraversal(root, new ArrayList<Integer>());
	}

	private List<Integer> findPostorderTraversal(TreeNode root, List<Integer> res) {
		if (root != null) {
			findPostorderTraversal(root.left, res);
			findPostorderTraversal(root.right, res);
			res.add(root.val);
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