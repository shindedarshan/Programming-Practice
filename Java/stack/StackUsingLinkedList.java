package stack;

import java.util.Iterator;

import support.ListNode;

public class StackUsingLinkedList implements Iterable<Integer> {
	
	ListNode top;
	
	public StackUsingLinkedList() {
		this.top = null;
	}
	
	public void push(int data) {
		ListNode node = new ListNode(data);
		if (top == null) top = node;
		else {
			node.next = top;
			top = node;
		}
	}
	
	public void pop() {
		if (!isEmpty()) top = top.next;
	}
	
	public boolean isEmpty() {
		if (this.top == null) return true;
		return false;
	}
	
	public int peek() {
		int val = -1;
		if (isEmpty()) {
			System.out.println("Underflow: List in empty.");
			return val;	
		}
		else {
			return top.val;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new StackIteratorUsingLinkedList(this.top);
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList o = new StackUsingLinkedList();
		o.push(5);
		o.push(10);
		o.push(15);
		Iterator<Integer> it = o.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		o.pop();
		o.pop();
		it = o.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
