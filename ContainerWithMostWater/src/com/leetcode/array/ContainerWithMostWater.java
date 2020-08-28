package com.leetcode.array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}

	public int maxArea(int[] height) {
		int maxArea = 0;
		if(height != null && height.length > 1) {
			int left = 0;
			int right = height.length-1;
			
			while(left < right) {
				maxArea = Math.max(maxArea,Math.min(height[left], height[right])*(right-left));
				if(height[left] < height[right]) {
					left ++;
					continue;
				}
				if(height[left] > height[right]) {
					right --;
					continue;
				}
				if(height[left] == height[right]) {
					left ++;
					right --;
					continue;
				}
			}
		}
		return maxArea;
	}
}
