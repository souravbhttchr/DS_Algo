package com.leetcode.trees;

public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
		System.out.println(new ValidateBST().isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root,long min,long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
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