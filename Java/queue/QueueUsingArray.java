package queue;

import java.util.Iterator;

public class QueueUsingArray implements Iterable<Integer> {
	
	int[] queue;
	int end = -1;
	
	public QueueUsingArray() {
		this.queue = new int[1];
	}
	
	public void enQueue(int data) {
		this.end++;
		if (this.end < this.queue.length) {
			this.queue[this.end] = data;
		}
		else {
			expand();
			this.queue[this.end] = data;
		}
	}
	
	private void expand() {
		int[] newQueue = new int[this.queue.length * 2];
		for (int i = 0; i < this.queue.length; i++) {
			newQueue[i] = this.queue[i];
		}
		this.queue = newQueue;
	}
	
	private void shrink() {
		int[] newQueue = new int[this.queue.length / 2];
		for (int i = 0; i <= this.end; i++) {
			newQueue[i] = this.queue[i];
		}
		this.queue = newQueue;
	}

	public int deQueue() {
		if (this.end ==  -1) {
			System.out.println("Underflow: Queue is empty.");
			return -1;
		}
		else {
			int data = this.queue[this.end];
			shift();
			this.end--;
			if (this.end < this.queue.length/4) shrink();
			return data;
		}
	}
	
	public boolean isEmpty() {
		return this.end == -1;
	}
	
	public int size() {
		return this.end + 1;
	}
	
	private void shift() {
		for (int i = 1; i <= this.end; i++) {
			this.queue[i-1] = this.queue[i];
		}
		this.queue[this.end] = 0;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new QueueItertorUsingArray(this.queue, this.end);
	}
	
	public class QueueItertorUsingArray implements Iterator<Integer> {
		int[] queueArr;
		int endIndex;
		int cur = 0;
		
		public QueueItertorUsingArray(int[] queueArr, int endIndex) {
			this.queueArr = queueArr;
			this.endIndex = endIndex;
		}

		@Override
		public boolean hasNext() {
			return cur <= this.endIndex;
		}

		@Override
		public Integer next() {
			int data =  this.queueArr[this.cur];
			this.cur++;
			return data;
		}
	}

	public static void main(String[] args) {
		QueueUsingArray o = new QueueUsingArray();
		System.out.println(o.size());
		System.out.println(o.isEmpty());
		o.enQueue(5);
		o.enQueue(10);
		o.enQueue(15);
		System.out.println(o.size());
		System.out.println(o.isEmpty());
		Iterator<Integer> it = o.iterator();
		while (it.hasNext()) System.out.println(it.next());
		o.deQueue();
		o.deQueue();
		System.out.println(o.size());
		System.out.println(o.isEmpty());
		it = o.iterator();
		while (it.hasNext()) System.out.println(it.next());
	}
}
