package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import support.ListNode;

public class MergeKSortedLists_23 {
	
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
		ListNode head = null;
		ListNode node = null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new ListNodeComparator());
		for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }
		while (!pq.isEmpty()) {
			if (node == null) {
				ListNode temp = pq.poll();
				head = temp;
				node = temp;
				if (temp.next != null) pq.add(temp.next);
			}
			else {
				ListNode temp = pq.poll();
				node.next = temp;
				node = node.next;
				if (temp.next != null) pq.add(temp.next);
			}
		}
		return head;
    }

	public static void main(String[] args) {
		ListNode[] arr = new ListNode[3];
		
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(4);
		n1.next.next = new ListNode(5);
		
		ListNode n2 = new ListNode(1);
		n2.next = new ListNode(3);
		n2.next.next = new ListNode(4);
		
		ListNode n3 = new ListNode(2);
		n3.next = new ListNode(6);
		
		arr[0] = n1;
		arr[1] = n2;
		arr[2] = n3;
		
		MergeKSortedLists_23 o = new MergeKSortedLists_23();
		ListNode res = o.mergeKLists(arr);
		System.out.println(res);
	}
	
	public class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if (o1.val < o2.val) return -1;
			if (o1.val > o2.val) return 1;
			else return 0;
		}
		
	}

}
