package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAirRoute {

	public static void main(String[] args) {
		int maxTravelDist = 10000;
		int[][] forwardRouteList = { { 1, 3000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } };
		int[][] returnRouteList = { { 1, 2000 }, { 2, 3000 }, { 3, 4000 }, { 4, 5000 } };

		List<int[]> returnList = findOptimalAirRoute(maxTravelDist, forwardRouteList, returnRouteList);

		for (int[] is : returnList) {
			System.out.println(is[0] + " " + is[1]);
		}
	}

	private static List<int[]> findOptimalAirRoute(int maxTravelDist, int[][] forwardRouteList,
			int[][] returnRouteList) {
		List<int[]> optimalList = new ArrayList<int[]>();
		if (maxTravelDist > 0 && null != forwardRouteList && null != returnRouteList) {
			Arrays.sort(forwardRouteList, (a, b) -> a[1] - b[1]); // nlogn
			Arrays.sort(returnRouteList, (a, b) -> a[1] - b[1]); // nlogn

			int maxVal = Integer.MIN_VALUE;
			int returnLength = returnRouteList.length;

			for (int i = 0, j = 0;;) { // m+n
				if (i < forwardRouteList.length && returnLength - j - 1 >= 0) {
					int totalVal = forwardRouteList[i][1] + returnRouteList[returnLength - j - 1][1];
					if (totalVal <= maxTravelDist) {
						if (totalVal > maxVal) {
							maxVal = totalVal;
							optimalList.clear();
							int[] newArr = { forwardRouteList[i][0], returnRouteList[returnLength - j - 1][0] };
							optimalList.add(newArr);
							i++;
						} else if (totalVal == maxVal) {
							int[] newArr = { forwardRouteList[i][0], returnRouteList[returnLength - j - 1][0] };
							optimalList.add(newArr);
							i++;
						} else if (totalVal < maxVal) {
							i++;
						}
					} else {
						j++;
					}
				} else {
					break;
				}
			}
		}
		return optimalList;
	}

}
