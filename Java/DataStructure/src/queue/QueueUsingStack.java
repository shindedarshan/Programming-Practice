package queue;

import java.util.Stack;

public class QueueUsingStack {
	Stack<String> enQ;
	Stack<String> deQ;
	
	public QueueUsingStack() {
		enQ = new Stack<String>();
		deQ = new Stack<String>();
	}
	
	public void enQueue(String s) {
		enQ.push(s);
	}
	
	public String deQueue() {
		if (enQ.isEmpty() && deQ.isEmpty()) {
			System.out.println("Underflow: Queue is empty.");
			return "";
		}
		else {
			if (deQ.isEmpty()) 
				while (!enQ.isEmpty())deQ.push(enQ.pop());
			return deQ.pop();
		}
	}
	
	public boolean isEmpty() {
		return enQ.isEmpty() && deQ.isEmpty();
	}
	
	public static void main(String[] args) {
		QueueUsingStack q = new QueueUsingStack();
		q.enQueue("H");
		q.enQueue("E");
		q.enQueue("L");
		q.enQueue("L");
		q.enQueue("O");
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}
