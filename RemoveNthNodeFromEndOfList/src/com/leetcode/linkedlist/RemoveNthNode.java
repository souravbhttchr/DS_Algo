package com.leetcode.linkedlist;

public class RemoveNthNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		int n = 1;
		System.out.println(new RemoveNthNode().removeNthFromEnd(head, n));
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n == 0) {
			return head;
		}
		
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode p3 = head;
		
		int count = 1;
		
		while(p1.next != null) {
			p1 = p1.next;
			if(count >= n) {
				p2 = p2.next;
			}
			if(count >= n+1) {
				p3 = p3.next;
			}
			count++;
		}
		
		if(count == n && p2 == head) {
			head = p2.next;
			return head;
		}
		if(count < n) {
			return head;
		}
		
		p3.next = p2.next;
		p2 = null;
		
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