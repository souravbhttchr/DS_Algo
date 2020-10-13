package com.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {

	int maxHeight = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
		System.out.println(new BinaryTreeRightSideView().rightSideView(root));
	}

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		Map<Integer, Integer> levelRightMap = new HashMap<>();
		levelRightMap = rightViewMap(root, 0, levelRightMap);
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<=maxHeight; i++) {
			result.add(levelRightMap.get(i));
		}
		
		return result;
	}

	private Map<Integer, Integer> rightViewMap(TreeNode root, int height, Map<Integer, Integer> levelRightMap) {
		maxHeight = Math.max(maxHeight, height);
		if (!levelRightMap.containsKey(height)) {
			levelRightMap.put(height, root.val);
		}
		if (root.right != null) {
			rightViewMap(root.right, height + 1, levelRightMap);
		}
		if (root.left != null) {
			rightViewMap(root.left, height + 1, levelRightMap);
		}

		return levelRightMap;
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