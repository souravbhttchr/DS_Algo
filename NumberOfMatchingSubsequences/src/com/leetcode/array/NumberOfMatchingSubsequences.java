package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfMatchingSubsequences {

	public static void main(String[] args) {
		String S = "abcde";
		String[] words = { "a", "bb", "acd", "ace" };
		System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq(S, words));
	}

	public int numMatchingSubseq(String S, String[] words) {
		if (null == S || S.length() == 0 || words == null || words.length == 0) {
			return 0;
		}
		int count = 0;
		Map<Character, Set<Integer>> sMap = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			if (!sMap.containsKey(S.charAt(i))) {
				sMap.put(S.charAt(i), new TreeSet<>());
			}
			sMap.get(S.charAt(i)).add(i);
		}

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int index = -1;
			for (int j = 0; j < word.length(); j++) {
				if (sMap.containsKey(word.charAt(j))) {
					int val = containsChar(sMap, word.charAt(j), index);
					if(val != -1) {
						index = val;
					} else {
						break;
					}
					if(j == word.length()-1) {
						count ++;
					}
				} else {
					break;
				}
			}
		}

		return count;
	}

	private int containsChar(Map<Character, Set<Integer>> sMap, char c, int index) {
		TreeSet<Integer> set = (TreeSet<Integer>) sMap.get(c);
		Integer val = set.higher(index);
		return null != val ? val.intValue() : -1;
	}
}
