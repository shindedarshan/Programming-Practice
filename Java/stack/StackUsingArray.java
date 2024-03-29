package stack;

import java.util.Iterator;

public class StackUsingArray implements Iterable<Integer>{
	
	int[] list;
	int n = -1;
	
	public StackUsingArray () {
		this.list = new int[1];
	}
	
	public void push(int data) {
		if (n >= this.list.length - 1) {
			this.list = expandList(this.list);
		}
		n++;
		this.list[n] = data;
	}
	
	private int[] expandList(int[] list) {
		int[] newList = new int[2 * list.length];
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		return newList;
	}

	public void pop() {
		this.list[n] = 0;
		n--;
	}
	
	public boolean isEmpty() {
		if (n == -1) return true;
		return false;
	}
	
	public int peek() {
		if (!isEmpty()) return this.list[n];
		else {
			System.out.println("Underflow: Linked list is empty.");
			return -1;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new StackIteratorUsingArray(this.list, n);
	}
	
	public static void main(String[] args) {
		StackUsingArray o = new StackUsingArray();
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
