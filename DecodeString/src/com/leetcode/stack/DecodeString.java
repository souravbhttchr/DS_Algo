package com.leetcode.stack;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s = "10[a]";
		System.out.println(new DecodeString().decodeString(s));
	}

	public String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		Stack<Integer> mStack = new Stack<>();
		String num = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num += s.charAt(i);
			}
			if (s.charAt(i) == '[') {
				mStack.push(Integer.parseInt(num));
				mStack.push(i);
				num = "";
			}
			if (s.charAt(i) == ']') {
				String sub = "";
				int open = mStack.pop();
				int it = mStack.pop();
				int digits = it / 10;
				if (digits < 1) {
					digits = 1;
				}
				else if (digits < 10 && digits >= 1) {
					digits = 2;
				}
				else if (digits < 100 && digits >= 10) {
					digits = 3;
				}
				else if (digits < 1000 && digits >= 100) {
					digits = 4;
				}
				for (int j = 0; j < it; j++) {
					sub += s.substring(open + 1, i);
				}
				s = s.replace(s.substring(open - digits, i + 1), sub);
				i = open - digits - 1;
			}
		}
		return s;
	}
}
