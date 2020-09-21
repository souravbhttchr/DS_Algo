package com.leetcode.array;

public class MaxLengthOfRepeatedSubArray_DP {

	int length = 0;
	int start = 0;

	public static void main(String[] args) {
		int A[] = { 0, 0, 0, 0, 1 };
		int B[] = { 1, 0, 0, 0, 0 };
		System.out.println(new MaxLengthOfRepeatedSubArray_DP().findLength(A, B));
	}

	public int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];

		int result = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}
}
