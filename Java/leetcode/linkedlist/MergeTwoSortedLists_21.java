package leetcode.linkedlist;

import support.ListNode;

public class MergeTwoSortedLists_21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        ListNode mergedHead = null;
		// the key to solve this is recursion 
        if(l1.val < l2.val) {
            mergedHead = l1;
            mergedHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergedHead = l2;
            mergedHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergedHead;
    }

	public static void main(String[] args) {
		MergeTwoSortedLists_21 o = new MergeTwoSortedLists_21();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		o.mergeTwoLists(l1, l2);
	}

}
