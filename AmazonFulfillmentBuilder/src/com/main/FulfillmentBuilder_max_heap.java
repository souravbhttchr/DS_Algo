package com.main;

import java.util.PriorityQueue;

public class FulfillmentBuilder_max_heap {

	public static void main(String[] args) {
		int[] parts = { 1, 2, 3, 4 };
		System.out.println(optimalTime(parts));
	}

	private static int optimalTime(int[] parts) {
		if (parts == null || parts.length == 1) {
			return 0;
		}

		PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> {
			if (a < b) {
				return -1;
			}
			return 1;
		});

		for (int size : parts) {
			max_heap.add(size);
		}

		int time = 0;

		while (!max_heap.isEmpty()) {
			int smallest1 = max_heap.poll();
			int smallest2 = max_heap.poll();
			int timeTaken = smallest1 + smallest2;
			if (!max_heap.isEmpty()) {
				max_heap.add(timeTaken);
			}
			time += timeTaken;
		}

		return time;
	}
}
