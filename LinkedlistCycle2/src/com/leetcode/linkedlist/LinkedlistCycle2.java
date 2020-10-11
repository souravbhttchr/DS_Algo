package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedlistCycle2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(-4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		
		System.out.println(new LinkedlistCycle2().detectCycle(head));
	}

	public ListNode detectCycle(ListNode head) {
		if(head == null) {
			return head;
		}
		
		Set<ListNode> set = new HashSet<>();
		ListNode p = head;
		
		while(p != null) {
			if(set.contains(p)) {
				return p;
			} else {
				set.add(p);
				p = p.next;
			}
		}
		
		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	ListNode(int x, ListNode next){
		val = x;
		this.next = next;
	}
}