package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKKeywords {

	public static void main(String[] args) {
		int k = 3;
		String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };

		System.out.println(findTopKBuzzwords(k, keywords, reviews));
	}

	private static List<String> findTopKBuzzwords(int k, String[] keywords, String[] reviews) {

		Map<String, Integer> countMap = new HashMap<>();
		PriorityQueue<Pair> min_heap = new PriorityQueue<>((a, b) -> {
			if (a.getCount() < b.getCount()) {
				return 1;
			}
			return -1;
		});

		Set<String> keySet = new HashSet<>(Arrays.asList(keywords));

		for (String string : reviews) {
			String[] words = string.toLowerCase().split(" ");
			for (String word : words) {
				if (keySet.contains(word)) {
					if (!countMap.containsKey(word)) {
						countMap.put(word, 1);
					} else {
						countMap.put(word, countMap.get(word) + 1);
					}
				}
			}
		}

		Iterator<String> iter = keySet.iterator();

		while (iter.hasNext()) {
			String elem = iter.next();
			if (null != countMap.get(elem)) {
				Pair p = new Pair();
				p.setS(elem);
				p.setCount(countMap.get(elem));
				min_heap.add(p);
			}
		}

		List<String> buzzwords = new ArrayList<String>(k);
		for (int i = 0; i < k; i++) {
			buzzwords.add(min_heap.poll().getS());
		}

		return buzzwords;
	}
}

class Pair {
	String s;
	int count;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}