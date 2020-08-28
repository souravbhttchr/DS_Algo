package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2_optimized {

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		System.out.println(new CombinationSum2_optimized().combinationSum2(candidates, target));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates != null && candidates.length > 0) {
			List<List<Integer>> ans = new ArrayList<>();
			Set<List<Integer>> unique = new HashSet<>();
			Arrays.sort(candidates);
			ans.addAll(findCombination(candidates, 0, 0, target, unique, null));
			return ans;
		}
		return new ArrayList<>();
	}

	private Set<List<Integer>> findCombination(int[] candidates, int index, int sum, int target,
			Set<List<Integer>> unique, List<Integer> sol) {
		if (sum == target) {
			List<Integer> val = new ArrayList<>();
			val.addAll(sol);
			unique.add(val);
			sol = null;
		} else {
			if (index < candidates.length && sum < target) {
				if (sol == null) {
					sol = new ArrayList<>();
				}
				sol.add(candidates[index]);
				findCombination(candidates, index + 1, sum + candidates[index], target, unique, sol);
				sol.remove(sol.size()-1);
				findCombination(candidates, index + 1, sum, target, unique, sol);
			}
		}
		return unique;
	}
}
