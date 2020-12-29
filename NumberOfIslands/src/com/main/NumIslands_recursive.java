package com.main;

public class NumIslands_recursive {

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
					numIslands += getNumIslands(grid, i, j);
				}
			}
		}
		return numIslands;
	}

	private static int getNumIslands(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return 0;
		}
		grid[i][j] = '0';
		
		getNumIslands(grid, i+1, j);
		getNumIslands(grid, i-1, j);
		getNumIslands(grid, i, j+1);
		getNumIslands(grid, i, j-1);
		
		return 1;
	}
}
