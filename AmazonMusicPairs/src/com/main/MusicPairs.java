package com.main;

import java.util.HashMap;
import java.util.Map;

public class MusicPairs {

	public static void main(String[] args) {
		int[] time = { 60, 60, 60 };

		System.out.println(findPairs(time));
	}

	private static int findPairs(int[] time) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int t : time) {
			if (t % 60 == 0)
				count += map.getOrDefault(0, 0);
			else
				count += map.getOrDefault(60 - t % 60, 0);
			map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
		}
		return count;
	}
}
