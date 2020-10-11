package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		new ReorderList().reorderList(head);
	}

	public void reorderList(ListNode head) {
		if (head != null) {
			List<ListNode> list = new ArrayList<>();
			ListNode p = head;
			while (p != null) {
				list.add(p);
				p = p.next;
			}
			int i = 0;
			for (; i < list.size(); i++) {
				int j = list.size() - 1 - i;
				if (j > i) {
					ListNode right = list.get(i).next;
					ListNode left = list.get(i);
					ListNode mid = list.get(j);
					left.next = mid;
					mid.next = right;
				} else {
					break;
				}
			}
			
			list.get(i).next = null;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}