package com.leetcode.stack;

public class BackSpaceStrings {

	public static void main(String[] args) {
		String S = "ab##";
		String T = "c#d#";
		System.out.println(new BackSpaceStrings().backspaceCompare(S, T));
	}

	public boolean backspaceCompare(String S, String T) {
		StringBuilder s = new StringBuilder();
		StringBuilder t = new StringBuilder();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != '#') {
				s.append(S.charAt(i));
			} else if(s.length() > 0) {
				s.deleteCharAt(s.length()-1);
			}
		}
		
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) != '#') {
				t.append(T.charAt(i));
			} else if(t.length() > 0) {
				t.deleteCharAt(t.length()-1);
			}
		}
		
		if(s.toString().equals(t.toString())) {
			return true;
		}
		return false;
	}
}
