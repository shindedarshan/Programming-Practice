package leetcode.linkedlist;

import support.ListNode;

public class AddTwoNumbers_2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode node = null; 
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = (l1 != null)? l1.val : 0;
			int n2 = (l2 != null)? l2.val : 0;
			int val = n1 + n2 + carry;
			carry = val / 10;
			val = val % 10;
			if (head == null) {
				head = new ListNode(val);
				node = head;
			}
			else {
				node.next = new ListNode(val);
				node = node.next;
			}
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		while(carry != 0) {
			node.next = new ListNode(carry % 10);
			node = node.next;
			carry /= 10;
		}
		return head;
    }

	public static void main(String[] args) {
		AddTwoNumbers_2 o = new AddTwoNumbers_2();
		
		ListNode n1 = new ListNode(5);
		n1.next = new ListNode(4);
		n1.next.next = new ListNode(3);
		
		ListNode n2 = new ListNode(5);
		n2.next = new ListNode(6);
		n2.next.next = new ListNode(4);
		
		o.addTwoNumbers(n1, n2);
	}

}
