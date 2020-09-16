package com.leetcode.array;

public class MaxSwap {

	public static void main(String[] args) {
		int num = 1993;
		System.out.println(new MaxSwap().maximumSwap(num));
	}

	public int maximumSwap(int num) {
		if (num < 10) {
			return num;
		}
		char[] arr = Integer.toString(num).toCharArray();
		int highestpos = 0;
		int index = -1;
		int startLoop = 0;
		int max = Integer.MIN_VALUE;
		boolean foundInt = false;

		for (int i = startLoop; i < arr.length; i++) {
			if (i != index) {
				if (arr[i] > max) {
					max = arr[i];
					index = i;
				}
				if(arr[i] == max) {
					index = i;
				}
			}

			if (i == arr.length - 1) {
				if (index == highestpos || arr[index] == arr[highestpos]) {
					highestpos++;
					index = startLoop;
					i = startLoop ++;
					max = Integer.MIN_VALUE;
				} else {
					foundInt = true;
					break;
				}
			}
		}

		if (foundInt) {
			char temp = arr[highestpos];
			arr[highestpos] = arr[index];
			arr[index] = temp;
		}

		return Integer.parseInt(String.valueOf(arr));
	}
}
