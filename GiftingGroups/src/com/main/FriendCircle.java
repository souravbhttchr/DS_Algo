package com.main;

public class FriendCircle {

	public static void main(String[] args) {
		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(new FriendCircle().findCircleNum(M));
	}

	public int findCircleNum(int[][] M) {
		boolean[] visited = new boolean[M.length];
		int cnt = 0;
		for (int i = 0; i < M.length; i++) {
			if (visited[i])
				continue;

			if (!visited[i]) { // dfs traverse the direct friends of "i" person
				visited[i] = true;
				dfs(M, i, visited);
				cnt++; // always count++ here as himself also is a group even though no other friends
			}
		}

		return cnt;
	}

	public void dfs(int[][] M, int i, boolean[] visited) {
		for (int j = 0; j < M.length; j++) {
			if (visited[j])
				continue;

			if (M[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(M, j, visited); // dfs traverse the direct friends of "j" person which is the indirect friend of
									// "i"
			}
		}
	}
}
