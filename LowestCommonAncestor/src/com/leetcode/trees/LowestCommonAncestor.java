package com.leetcode.trees;

public class LowestCommonAncestor {

	int lcaHeight = 0;
	boolean pFound = false;
	boolean qFound = false;
	TreeNode lca;

	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(1);
		TreeNode p = new TreeNode(6);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(0);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(7);
		TreeNode q = new TreeNode(4);

		root.left = a;
		root.right = b;
		a.left = p;
		a.right = c;
		c.left = f;
		c.right = q;
		b.left = d;
		b.right = e;*/
		
		TreeNode root = new TreeNode(2);
		TreeNode a = new TreeNode(1);
		
		root.left = null;
		root.right = a;

		System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, a, root).val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
            return null;
        }
		//if root is either one of the descent
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
		//If left and right start to diverage at this root, then this root is the lowest common ancestor
        if (right != null && left != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}