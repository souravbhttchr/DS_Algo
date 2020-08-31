package com.leetcode.array;

import java.util.Arrays;

public class LIS_Brute_Force_On2 {

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(new LIS_Brute_Force_On2().lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 1; i < nums.length;i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
