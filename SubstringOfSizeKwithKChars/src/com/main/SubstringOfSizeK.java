package com.main;

import java.util.HashSet;
import java.util.Set;

public class SubstringOfSizeK {

	public static void main(String[] args) {
		String s = "awaglknagawunagwkwagl";
		int k = 4;
		System.out.println(new SubstringOfSizeK().uniqueSubstringK(s, k));
	}

	public static Set<String> uniqueSubstringK(String s, int k) {
		Set<String> uniqueStrings = new HashSet<>();
		if (s == null || s.length() == 0 || k == 0)
			return uniqueStrings;

		Set<Character> window = new HashSet<>();

		for (int i = 0; i < s.length();) {
			for (int j = 0; j < s.length();) {
				if(i == j) {
					window.add(s.charAt(i));
					j++;
				}
				else {
					if(window.contains(s.charAt(j))) {
						for(int l = i; l <=j; l++) {
							if(s.charAt(l) != s.charAt(j)) {
								window.remove(s.charAt(l));
							} else {
								window.remove(s.charAt(l));
								i = l+1;
								break;
							}
						}
						window.add(s.charAt(j));
						j++;
					} else {
						window.add(s.charAt(j));
						j++;
					}
				}
				
				if(window.size() == k) {
					uniqueStrings.add(s.substring(i, j));
					window.remove(s.charAt(i));
					i++;
				}
				
				if(j >= s.length()) {
					i = s.length();
					break;
				}
			}
		}
		return uniqueStrings;
	}
}
