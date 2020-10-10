package com.leetcode.linkedlist;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1,
				new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		int x = 3;
		System.out.println(new PartitionList().partition(head, x));
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}

		ListNode p = head;
		ListNode q = null;
		ListNode r = null;
		ListNode l = null;

		while (p != null) {
			if (r == null && p.val < x) {
				p = p.next;
			} else {
				if (r == null && p.val >= x) {
					r = p;
					p = p.next;
				} else if (r != null && p.val < x) {
					if (q != null) {
						q.next = p;
						l.next = p.next;
						p.next = r;
						q = q.next;
					} else {
						l.next = p.next;
						p.next = r;
						q = p;
						head = q;
					}
					p = l.next;
				} else if (p.val >= x) {
					p = p.next;
				}
			}

			if (p != head && r == null && q == null) {
				q = head;
			} else if (r == null) {
				q = q.next;
			}

			if (p != head) {
				if (l == null) {
					l = head;
				} else if(l.next != p){
					l = l.next;
				}
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