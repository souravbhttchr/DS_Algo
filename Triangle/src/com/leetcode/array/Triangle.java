package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> r1 = new ArrayList<>();
		List<Integer> r2 = new ArrayList<>();
		List<Integer> r3 = new ArrayList<>();
		r1.add(-1);
		r2.add(2);
		r2.add(3);
		r3.add(1);
		r3.add(-1);
		r3.add(-3);
		triangle.add(r1);
		triangle.add(r2);
		triangle.add(r3);
		System.out.println(new Triangle().minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int minLowerLevelVal = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, triangle.get(i).get(j) + minLowerLevelVal);
			}
		}
		return triangle.get(0).get(0);
	}
}
