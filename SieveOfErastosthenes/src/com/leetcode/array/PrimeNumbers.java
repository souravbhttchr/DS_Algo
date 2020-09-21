package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {

	public static void main(String[] args) {
		int limit = 99999999;
		int n = 5000;
		List<Integer> primes = sieve(limit);
		System.out.println(primes.get(n));
	}

	private static List<Integer> sieve(int high) {
		boolean[] nums = new boolean[high+1];
		Arrays.fill(nums, true);
		for (int i = 2; i <= high; i++) {
			if (nums[i]) {
				for (int j = 2; i * j <= high; j++) {
					nums[i*j] = false;
				}
			}
		}

		List<Integer> primes = new ArrayList<>();
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i]) {
				primes.add(i);
			}
		}
		
		return primes;
	}

}
