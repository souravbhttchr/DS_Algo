package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class LIS_MyVersion {

	int maxLength;

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(new LIS_MyVersion().lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums != null) {
			if (nums.length == 1) {
				return 1;
			}
			if (nums.length > 1) {
				for (int i = 0; i < nums.length; i++) {
					List<Integer> subSeq = new ArrayList<>();
					subSeq.add(nums[i]);
					for (int j = i + 1; j < nums.length; j++) {
						if (nums[j] > subSeq.get(subSeq.size() - 1)) {
							subSeq.add(nums[j]);
						} else if(subSeq.size() > 1 && nums[j] <= subSeq.get(subSeq.size() - 1)){
							maxLength = Math.max(maxLength, subSeq.size());
							for (int k = subSeq.size() - 1; k >= 1; k--) {
								if (nums[j] <= subSeq.get(k)) {
									subSeq.remove(k);
								}
							}
							subSeq.add(nums[j]);
						}
						maxLength = Math.max(maxLength, subSeq.size());
					}
				}

				return maxLength;
			}
			return 0;
		}
		return 0;
	}
}
