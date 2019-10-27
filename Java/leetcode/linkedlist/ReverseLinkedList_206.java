package leetcode.linkedlist;

import support.ListNode;

public class ReverseLinkedList_206 {

	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(5);
		ReverseLinkedList_206 o = new ReverseLinkedList_206();
		ListNode out = o.reverseList(n);
		System.out.println(out);
	}
	
	public ListNode reverseList(ListNode n) {
		if (n == null) return n;
		ListNode h = null;
		return rev(n, h)[1];
    }

	private ListNode[] rev(ListNode n, ListNode h) {
		if (n.next == null && h == null) {
			h = n; return new ListNode[] {n,h};
		}
		ListNode[] arr = rev(n.next, h);
		n.next = null;
		arr[0].next = n;
		return new ListNode[] {n,arr[1]};
	}

}
