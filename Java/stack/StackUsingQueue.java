package stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	Queue<String> q1;
	Queue<String> q2;
	
	public StackUsingQueue() {
		this.q1 = new LinkedList<String>();
		this.q2 = new LinkedList<String>();
	}
	
	public void push(String data) {
		this.q2.add(data);
		while (!q1.isEmpty()) {
			String s = q1.remove();
			q2.add(s);
		}
		Queue<String> q = q1;
		q1 = q2;
		q2 = q;
	}
	
	public String pop() {
		if (!isEmpty()) return q1.remove();
		else {
			System.out.println("Underflow: Stack is empty.");
			return "";
		}
	}
	
	public boolean isEmpty() {
		return this.q1.size() == 0;
	}
	
	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		s.push("H");
		s.push("E");
		s.push("L");
		s.push("L");
		s.push("O");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
