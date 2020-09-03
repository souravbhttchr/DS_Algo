package com.leetcode.array;

public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] nums = {2,-5,-2,-4,3};
		System.out.println(new MaxProductSubArray().maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < length; i++) {
            int temp_max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            max = temp_max;
            ans = Math.max(ans, max);
        }
        return ans;
	}
}
