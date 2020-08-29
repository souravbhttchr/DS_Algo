package com.leetcode.array;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {};
		int target = 17;
		System.out.println(new Search2DMatrix().searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix != null && matrix.length != 0) {
			return find(matrix, target, 0, matrix.length - 1, matrix[0].length - 1);
		}
		return false;
	}

	private boolean find(int[][] matrix, int target, int start, int end, int cols) {
		if (end - start >= 2) {
			int mid = (start + end) / 2;
			if(matrix[mid][cols] == target) {
				return true;
			}
			if (matrix[mid][cols] > target) {
				return find(matrix, target, start, mid, cols);
			}
			if (matrix[mid][cols] < target) {
				return find(matrix, target, mid, end, cols);
			}
		}
		if(end - start == 1) {
			for (int val : matrix[start]) {
				if (target == val) {
					return true;
				}
			}
			for (int val : matrix[end]) {
				if (target == val) {
					return true;
				}
			}
		}
		if (start == end) {
			for (int val : matrix[start]) {
				if (target == val) {
					return true;
				}
			}
		}
		return false;
	}
}
