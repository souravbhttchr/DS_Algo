package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {

		int[][] matrix = {};
		System.out.println(new SpiralMatrix().spiralOrder(matrix));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix != null && matrix.length > 0) {
			List<Integer> rows = new ArrayList<>(matrix.length);
			List<Integer> columns = new ArrayList<>(matrix[0].length);
			for (int i = 0; i < matrix.length; i++) {
				rows.add(i);
			}
			for (int i = 0; i < matrix[0].length; i++) {
				columns.add(i);
			}

			while (rows.size() != 0 && columns.size() != 0) {
				for (Integer colNum : columns) {
					if (rows.size() > 0 && columns.size() > 0) {
						ans.add(matrix[rows.get(0)][colNum]);
					}
				}
				if (rows.size() > 0) {
					rows.remove(0);
				}
				for (Integer rowNum : rows) {
					if (rows.size() > 0 && columns.size() > 0) {
						ans.add(matrix[rowNum][columns.get(columns.size() - 1)]);
					}
				}
				if (columns.size() > 0) {
					columns.remove(columns.get(columns.size() - 1));
				}
				for (int i = columns.size() - 1; i >= 0; i--) {
					if (rows.size() > 0 && columns.size() > 0) {
						ans.add(matrix[rows.get(rows.size() - 1)][columns.get(i)]);
					}
				}
				if (rows.size() > 0) {
					rows.remove(rows.size() - 1);
				}
				for (int i = rows.size() - 1; i >= 0; i--) {
					if (rows.size() > 0 && columns.size() > 0) {
						ans.add(matrix[rows.get(i)][columns.get(0)]);
					}
				}
				if (columns.size() > 0) {
					columns.remove(0);
				}
			}

		}
		return ans;
	}
}
