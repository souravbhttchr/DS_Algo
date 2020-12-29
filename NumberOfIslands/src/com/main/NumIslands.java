package com.main;

public class NumIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int numIslands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					int count = 0;
					if (isWater(grid, i - 1, j)) {
						count += 1;
					}
					if (isWater(grid, i, j - 1)) {
						count += 1;
					}
					if (isWater(grid, i + 1, j)) {
						count += 1;
					}
					if (isWater(grid, i, j + 1)) {
						count += 1;
					}

					if (count >= 3) {
						numIslands += 1;
					}
				}
			}
		}

		return numIslands;
	}

	private static boolean isWater(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
			return true;
		} else {
			if (grid[i][j] == '0') {
				return true;
			} else {
				return false;
			}
		}
	}
}
