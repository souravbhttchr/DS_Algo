package com.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeAirRouteOptimized {

	static int maxVal = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int maxTravelDist = 10000;
		int[][] forwardRouteList = { { 1, 3000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } };
		int[][] returnRouteList = { { 1, 2000 }, { 2, 3000 }, { 3, 4000 }, { 4, 5000 } };

		List<List<Integer>> returnList = findOptimalAirRoute(maxTravelDist, forwardRouteList, returnRouteList);

		System.out.println(returnList);

	}

	private static List<List<Integer>> findOptimalAirRoute(int maxTravelDist, int[][] forwardRouteList,
			int[][] returnRouteList) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		List<Integer> pair = new ArrayList<>();
		result = backtrack(maxTravelDist, forwardRouteList, returnRouteList, 0, 0, pair, result);
		return new ArrayList<>(result);
	}

	private static Set<List<Integer>> backtrack(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList,
			int posf, int posr, List<Integer> pair, Set<List<Integer>> result) {

		if (pair.size() == 2) {
			result.add(new ArrayList<>(pair));
			pair.clear();
		}

		for (int i = posf, j = posr; i < forwardRouteList.length && j < returnRouteList.length; i++, j++) {
			int totalVal = forwardRouteList[i][1] + returnRouteList[j][1];
			if (totalVal <= maxTravelDist) {
				if (totalVal > maxVal) {
					result.clear();
					pair.add(forwardRouteList[i][0]);
					pair.add(returnRouteList[j][0]);
					maxVal = totalVal;
					backtrack(maxTravelDist, forwardRouteList, returnRouteList, i+1, j, pair, result);
				} else if (totalVal == maxVal) {
					pair.add(forwardRouteList[i][0]);
					pair.add(returnRouteList[j][0]);
					backtrack(maxTravelDist, forwardRouteList, returnRouteList, i+1, j, pair, result);
				} else if (totalVal < maxVal) {
					continue;
				}
			}
		}

		return result;
	}

}
