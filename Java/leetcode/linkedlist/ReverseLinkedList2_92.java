package leetcode.linkedlist;

import support.ListNode;

public class ReverseLinkedList2_92 {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) return null;
		
		ListNode cur = head; 
		ListNode prev = null;
		int i = 1;
		
		while(i != m && cur != null) {
			prev = cur;
			cur = cur.next;
			i++;
		}
		ListNode a1 = prev, a2 = null;
		ListNode end = cur, start = null;
		
		while ((a1 != null || m == 1) && (a2 == null && cur != null)) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
			i++;
			if (i > n) {a2 = cur; start = prev;}
		}
		if (a1 != null) a1.next = start; 
		else head = start;
		
		end.next = a2;
		
		return head;
    }

	public static void main(String[] args) {
		ReverseLinkedList2_92 o = new ReverseLinkedList2_92();
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(5);
		o.reverseBetween(n, -1, 5);
	}

}
