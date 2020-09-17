package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImmediateLargeNumber {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 9, 1, 25, 10 };

		System.out.println(new ImmediateLargeNumber().findLargeArray(arr));
	}

	private List<Integer> findLargeArray(int[] arr) {
		if (arr != null && arr.length < 2) {
			List<Integer> res = new ArrayList<>();
			if(arr.length == 0) {
				return res;
			} else {
				res.add(arr[0]);
				return res;
			}
		}

		List<Integer> largeArr = new ArrayList<>();
		Stack<Integer> mStack = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (mStack.isEmpty()) {
				mStack.push(arr[i]);
			} else {
				int curr = mStack.size()-1;
				while (curr >= 0) {
					int popped = mStack.pop();
					if (popped < arr[i]) {
						largeArr.add(arr[i]);
					} else {
						mStack.push(popped);
					}
					curr--;
				}
				mStack.push(arr[i]);
			}
		}
		if (!mStack.isEmpty()) {
			for (int i = 0; i < mStack.size(); i++) {
				largeArr.add(-1);
			}
		}

		return largeArr;
	}
}
