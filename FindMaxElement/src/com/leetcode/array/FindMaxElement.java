package com.leetcode.array;

public class FindMaxElement {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(new FindMaxElement().binarySearch(arr, 0, arr.length - 1));
	}

	public int binarySearch(int[] arr, int front, int end) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		if (arr != null) {
			if(arr.length == 1) {
				return arr[0];
			}
			else if (front < end) {
				int mid = (front + end) / 2;
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return arr[mid];
				} else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
					binarySearch(arr, mid, end);
				} else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					binarySearch(arr, front, mid);
				}
			}
		}
		return 0;
	}
}
