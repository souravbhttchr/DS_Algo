package com.leetcode.stack;

import java.util.Stack;

public class EvaluateRPN {

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		System.out.println(new EvaluateRPN().evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<String> mStack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (i == 0 && isOperator(tokens[i])) {
				return 0;
			}
			if (tokens[i] == null || tokens[i].trim().length() == 0) {
				return 0;
			}
			if (!isOperator(tokens[i])) {
				mStack.push(tokens[i]);
			} else {
				int rightOper = Integer.parseInt(mStack.pop());
				int leftOper = Integer.parseInt(mStack.pop());
				if (tokens[i].equals("+")) {
					mStack.push(Integer.toString(rightOper + leftOper));
				}
				if (tokens[i].equals("-")) {
					mStack.push(Integer.toString(leftOper - rightOper));
				}
				if (tokens[i].equals("*")) {
					mStack.push(Integer.toString(rightOper * leftOper));
				}
				if (tokens[i].equals("/")) {
					mStack.push(Integer.toString(leftOper / rightOper));
				}
			}
		}
		if (mStack.size() == 1) {
			return Integer.parseInt(mStack.pop());
		}
		return 0;
	}

	private boolean isOperator(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
			return true;
		}
		return false;
	}
}
