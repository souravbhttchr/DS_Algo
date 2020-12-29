package com.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringOfSizeK_optimized {

	public static void main(String[] args) {
		String s = "awaglknagawunagwkwagl";
		int k = 4;
		System.out.println(new SubstringOfSizeK_optimized().uniqueSubstringK(s, k));
	}

	public static List<String> uniqueSubstringK(String s, int k) {
		Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            for (; window.contains(s.charAt(end)); start++) {
                window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(result);
	}
}
