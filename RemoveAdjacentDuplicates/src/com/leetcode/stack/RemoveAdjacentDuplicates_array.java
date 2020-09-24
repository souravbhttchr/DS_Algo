package com.leetcode.stack;

public class RemoveAdjacentDuplicates_array {

	public static void main(String[] args) {
		String S = "adabbadaca";
		System.out.println(new RemoveAdjacentDuplicates_array().removeDuplicates(S));
	}

	public String removeDuplicates(String S) {
		if (S == null || S.length() == 0) {
			return S;
		}
		int i = 0;
		char[] arr = S.toCharArray();
		for (char c : arr) {
			if (i > 0 && c == arr[i - 1]) {
				i--;
			} else {
				arr[i] = c;
				i++;
			}
		}
		return new String(arr, 0, i);
	}
}
