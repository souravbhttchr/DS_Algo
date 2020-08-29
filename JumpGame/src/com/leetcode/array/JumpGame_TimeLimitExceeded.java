package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class JumpGame_TimeLimitExceeded {

	Map<Integer, Boolean> reachedMap = new HashMap<>();

	public static void main(String[] args) {
		int[] nums = { 1,2,3 };
		System.out.println(new JumpGame_TimeLimitExceeded().canJump(nums));
	}

	public boolean canJump(int[] nums) {
		if (nums != null && nums.length > 0) {
			if (nums.length == 1) {
				return true;
			} else {
				return canJump(nums, 0);
			}
		}
		return false;
	}

	private boolean canJump(int[] nums, int index) {
		if (reachedMap.containsKey(index)) {
			return reachedMap.get(index);
		} else {
			if (index == nums.length - 1) {
				reachedMap.put(index, true);
				return reachedMap.get(index);
			} else {
				boolean hasReached = false;
				if (index + nums[index] > nums.length - 1) {
					return true;
				}
				for (int i = nums[index]; i >= 1; i--) {
					hasReached = canJump(nums, index + i);
					if(hasReached) {
						break;
					}
				}
				reachedMap.put(index, hasReached);
			}
			return reachedMap.get(index);
		}
	}
}
