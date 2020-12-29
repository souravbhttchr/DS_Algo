package com.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit", "a" };
		System.out.println(findMostCommonWOrd(paragraph, banned));
	}

	private static String findMostCommonWOrd(String paragraph, String[] banned) {

		String[] words = paragraph.toLowerCase().split("\\W+");
		Map<String, Integer> wordFreq = new HashMap<>();
		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
		int maxFreq = 0;
		String mostCommon = null;

		for (String word : words) {
			if (!bannedSet.contains(word)) {
				if (!wordFreq.containsKey(word)) {
					wordFreq.put(word, 1);
					if (maxFreq < 1) {
						maxFreq = 1;
						mostCommon = word;
					}
				} else {
					int newCount = wordFreq.get(word) + 1;
					wordFreq.put(word, newCount);
					if(maxFreq < newCount) {
						maxFreq = newCount;
						mostCommon = word;
					}
				}
			}
		}

		return mostCommon;
	}

}
