package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LargestItems {

	public static void main(String[] args) {
		String[][] itemAssociation = { { "Fridge", "Stand" }, { "Washing Machine", "Scaling powder" }, { "Washing Machine", "Detergent" }, {"Fridge", "Stabilizer"} };

		System.out.println(findLargestAssociation(itemAssociation));
	}

	private static List<String> findLargestAssociation(String[][] itemAssociation) {

		List<Set<String>> associations = new ArrayList<>();
		Map<String, Set<String>> assocMap = new HashMap<>();

		for (String[] assoc : itemAssociation) {
			Set<String> currentSet = null;
			for (int i = 0; i < assoc.length; i++) {
				if (i == 0) {
					if (!assocMap.containsKey(assoc[i])) {
						currentSet = new TreeSet<>();
						currentSet.add(assoc[i]);
						associations.add(currentSet);
					}
					else {
						currentSet = assocMap.get(assoc[i]);
					}
				} else if (i > 0) {
					currentSet.add(assoc[i]);
				}
				assocMap.put(assoc[i], currentSet);
			}
		}

		List<List<String>> longestAssocs = new ArrayList<>();
		List<String> longestAssoc = null;
		int maxLength = 0;
		
		for (Set<String> set : associations) {
			if(set.size() > maxLength) {
				longestAssocs.clear();
				maxLength = set.size();
				longestAssoc = new ArrayList<>(set);
				longestAssocs.add(longestAssoc);
			}
			else if(set.size() == maxLength) {
				longestAssoc = new ArrayList<>(set);
				longestAssocs.add(longestAssoc);
			}
		}
		
		return longestAssoc;
	}

}
