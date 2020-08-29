package com.leetcode.array;

public class JumpGame_optimized {

	public static void main(String[] args) {
		int[] nums = { 3,2,1,0,4 };
		System.out.println(new JumpGame_optimized().canJump(nums));
	}

	public boolean canJump(int[] nums) {
        int k=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<k){
                k++;
            }
            else{
                k=1;
            }
        }
        if(k==1)
            return true;
        return false;
    }
}
