package stack;

import java.util.Iterator;

import support.ListNode;

public class StackIteratorUsingLinkedList implements Iterator<Integer> {
	
	ListNode curNode;
	
	public StackIteratorUsingLinkedList (ListNode node) {
		this.curNode = node;
	}

	@Override
	public boolean hasNext() {
		if (this.curNode != null) return true;
		return false;
	}

	@Override
	public Integer next() {
		int val = curNode.val;
		curNode = curNode.next;
		return val;
	}

}
