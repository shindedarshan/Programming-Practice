package queue;

import java.util.Iterator;

import support.ListNode;

public class QueueUsingLinkedList implements Iterable<Integer> {
	
	ListNode start;
	ListNode end;
	
	public QueueUsingLinkedList() {
		this.start = null;
		this.end = null;
	}
	
	public void enQueue(int data) {
		ListNode node = new ListNode(data);
		if (isEmpty()) {
			start = node;
			end = start;
		}
		else {
			end.next = node;
			end = end.next;
		}
	}
	
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Underflow: Queue is empty.");
			return -1;
		}
		else if (start == end) {
			int data = start.val;
			start = null;
			end = null;
			return data;
		}
		else {
			int data = start.val;
			start = start.next;
			return data;
		}
	}
	
	public boolean isEmpty() {
		return start == end && start == null;
	}
	
	public int size() {
		if (start == end && start == null) return 0;
		else {
			int count = 0;
			ListNode cur = start;
			while (cur != null) {
				count++;
				cur = cur.next;
			}
			return count;
		}
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new QueueIteratorUsingLinkedList(start);
	}

	public static void main(String[] args) {
		QueueUsingLinkedList o = new QueueUsingLinkedList();
		System.out.println(o.isEmpty());
		o.enQueue(5);
		o.enQueue(10);
		o.enQueue(15);
		o.enQueue(20);
		System.out.println(o.isEmpty());
		System.out.println(o.size());
		o.deQueue();
		o.deQueue();
		System.out.println(o.size());
		Iterator<Integer> it = o.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
