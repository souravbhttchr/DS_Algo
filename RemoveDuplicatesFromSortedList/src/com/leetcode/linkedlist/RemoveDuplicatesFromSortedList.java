package com.leetcode.linkedlist;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1,
				new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2)))))));
		System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(head));
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode p1 = head;

		while (p1.next != null) {
			if (p1.val == p1.next.val) {
				ListNode p2 = p1.next;
				p1.next = p1.next.next;
				p2 = null;
			} else {
				p1 = p1.next;
			}
		}
		return head;
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