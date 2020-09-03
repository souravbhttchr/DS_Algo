package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {
		int[] nums = { 1,2,3,4,1 };
		int k = 5;
		System.out.println(new SubArraySum().subarraySum(nums, k));
	}

	public int subarraySum(int[] nums, int k) {
        int sum = 0 ;
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        int ans = 0;
        for( int i = 0 ; i < nums.length;i++)
        {
            sum+=nums[i];
            if(m.containsKey(sum-k))
                ans+=m.get(sum-k);
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
