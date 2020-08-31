package com.leetcode.array;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCB";
		System.out.println(new WordSearch().exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && exist(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if (word.charAt(index) != board[i][j]) {
			return false;
		}
		
		char temp = board[i][j];
		board[i][j] = '*';
		
		if (exist(board, word, i + 1, j, index + 1) || exist(board, word, i - 1, j, index + 1)
				|| exist(board, word, i, j + 1, index + 1) || exist(board, word, i, j - 1, index + 1)) {
			return true;
		}

		board[i][j] = temp;
		
		return false;
	}
}
