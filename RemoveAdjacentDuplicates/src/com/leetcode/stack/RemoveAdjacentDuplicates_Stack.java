package com.leetcode.stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates_Stack {

	public static void main(String[] args) {
		String S = "adabbadaca";
		System.out.println(new RemoveAdjacentDuplicates_Stack().removeDuplicates(S));
	}

	public String removeDuplicates(String S) {
		if(S == null || S.length() == 0) {
			return S;
		}
		
		Stack<Character> mStack = new Stack<>();
		for(int i=0; i<S.length(); i++) {
			if(!mStack.isEmpty() && mStack.peek().charValue() == S.charAt(i)) {
				mStack.pop();
			} else {
				mStack.push(S.charAt(i));
			}
		}
		StringBuilder res = new StringBuilder();
		while(!mStack.isEmpty()) {
			res = res.append(mStack.pop().charValue());
		}
		
		return res.reverse().toString();
	}
}
