package com.leetcode.array;

public class Search2DMatrix2 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 20;
		System.out.println(new Search2DMatrix2().searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix != null && matrix.length > 0) {
			return find(matrix, target, 0, matrix.length - 1, matrix[0].length - 1);
		}
		return false;
	}

	private boolean find(int[][] matrix, int target, int start, int end, int cols) {
		if (end - start > 1) {
			int mid = (end + start) / 2;
			if (matrix[mid][cols] == target || matrix[mid][0] == target) {
				return true;
			}
			if (matrix[mid][cols] > target && matrix[mid][0] < target) {
				boolean result = search(matrix[mid], target);
				if (!result) {
					return find(matrix, target, mid, end, cols) || find(matrix, target, start, mid, cols);
				}
				return result;
			}
			if (matrix[mid][cols] < target) {
				return find(matrix, target, mid, end, cols);
			}
			if (matrix[mid][0] > target) {
				return find(matrix, target, start, mid, cols);
			}
		}
		if (end - start == 1) {
			return search(matrix[start], target) || search(matrix[end], target);
		}
		if (end == start) {
			return search(matrix[start], target);
		}
		return false;
	}

	private boolean search(int[] arr, int target) {
		for (int i : arr) {
			if (i == target) {
				return true;
			}
		}

		return false;
	}
}
