package queue;

import java.util.Iterator;

import support.ListNode;

public class QueueIteratorUsingLinkedList implements Iterator<Integer> {
	
	ListNode start;
	public QueueIteratorUsingLinkedList(ListNode start) {
		this.start = start;
	}

	@Override
	public boolean hasNext() {
		return start != null;
	}

	@Override
	public Integer next() {
		int data = start.val;
		start = start.next;
		return data;
	}

}
