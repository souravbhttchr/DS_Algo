package com.leetcode.stack;

import java.util.Stack;

public class ScoreOfParentheses {

	int processed = -1;
	public static void main(String[] args) {
		String S = "()";
		System.out.println(new ScoreOfParentheses().scoreOfParentheses(S));
	}
	
	public int scoreOfParentheses(String S) {
		if(S == null || S.length() == 0) {
			return 0;
		}
		if(S.length() == 2) {
			return 1;
		}
		
		return findScore(S, new Stack<Character>(), 0, 0.5f);
	}

	private int findScore(String s, Stack<Character> stack, int index, float val) {
		for(int i = index; i<s.length(); i++) {
			processed = i;
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				stack.pop();
				val = 2*val;
				if(i+1 < s.length() && s.charAt(i+1) != s.charAt(i)) {
					val += findScore(s, new Stack<Character>(), i+1, 0.5f);
					i = processed;
				}
				if(stack.isEmpty()) {
					break;
				}
			}
		}
		
		return (int) val;
	}
}
