package com.bst;

public class BST {

	public static void main(String[] args) {
		Node root = new Node(5, new Node(4, new Node(3, null, null), null), new Node(6, null, null));
		System.out.println(new BST().isBST(root));
	}

	public boolean isBST(Node root) {
		if(root != null) {
			boolean left = isBST(root.left);
			boolean right = isBST(root.right);
			if(left && right && isLeftSmaller(root) && isRightBigger(root)) {
				return true;
			}
			return false;
		}
		return true;
	}

	private boolean isRightBigger(Node root) {
		if(root.right != null && root.right.val > root.val) {
			return true;
		} else if(root.right == null) {
			return true;
		}
		return false;
	}

	private boolean isLeftSmaller(Node root) {
		if(root.left != null && root.left.val < root.val) {
			return true;
		}
		else if(root.left == null) {
			return true;
		}
		return false;
	}
}

class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}