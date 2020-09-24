package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(8, new TreeNode(9), null))));
		System.out.println(new ZigzagLevelOrderTraversal().zigzagLevelOrder(root));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root != null) {
			List<List<Integer>> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			List<TreeNode> temp = new ArrayList<>();
			stack.push(root);
			return findZigzagTraversal(stack, result, temp, 0);
		}
		return new ArrayList<>();
	}

	private List<List<Integer>> findZigzagTraversal(Stack<TreeNode> stack, List<List<Integer>> result,
			List<TreeNode> temp, int level) {

		List<Integer> levelList = new ArrayList<>();

		if (level % 2 == 0) {
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				temp.add(node);
				levelList.add(node.val);
			}
			result.add(levelList);
			for (TreeNode node : temp) {
				if (node.left != null) {
					stack.push(node.left);
				}
				if (node.right != null) {
					stack.push(node.right);
				}
			}
			temp.clear();
			if (!stack.isEmpty()) {
				findZigzagTraversal(stack, result, temp, level + 1);
			}
		} else {
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				temp.add(node);
				levelList.add(node.val);
			}
			result.add(levelList);
			for (TreeNode node : temp) {
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
			temp.clear();
			if (!stack.isEmpty()) {
				findZigzagTraversal(stack, result, temp, level + 1);
			}
		}

		return result;
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