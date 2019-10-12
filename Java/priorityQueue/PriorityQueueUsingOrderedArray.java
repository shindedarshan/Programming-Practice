package priorityQueue;

public class PriorityQueueUsingOrderedArray {
	int n;
	String[] pq;
	
	public PriorityQueueUsingOrderedArray() {
		this.pq = new String[1];
		pq[0] = "";
		this.n = -1;
	}
	
	public void insert(String s) {
		if (isEmpty()) {
			pq[0] = s;
			n++;
		}
		else {
			if (++n == pq.length) expand();
			int i;
			for (i = 0; i < n; i++) {
				if (pq[i].compareTo(s) < 0) continue;
				shift(i, n-1);
				pq[i] = s;
				break;
			}
			if (i == n) pq[i] = s;
		}
	}
	
	private void shift(int p, int q) {
		for (int i = q; i >= p; i-- ) {
			pq[i + 1] = pq[i];
		}
	}

	public boolean isEmpty() {
		return n == -1;
	}
	
	public String delMax() {
		if (n == -1) {
			System.out.println("Underflow: Priority queue is empty.");
			return "";
		}
		String data = pq[n--];
		pq[n+1] = "";
		if (n < pq.length / 4) shrink();
		return data;
	}
	
	private void expand() {
		String[] newPQ = new String[pq.length * 2];
		for (int i = 0; i < newPQ.length; i++) {
			if (i < pq.length) newPQ[i] = pq[i];
			else newPQ[i] = "";
		}
		this.pq = newPQ;
	}
	
	private void shrink() {
		String[] newPQ = new String[pq.length / 2];
		for (int i = 0; i <= n; i++) {
			newPQ[i] = pq[i];
		}
		this.pq = newPQ;
	}
	
	public static void main(String[] args) {
		PriorityQueueUsingOrderedArray o = new PriorityQueueUsingOrderedArray();
		o.insert("H");
		o.insert("E");
		o.insert("L");
		o.insert("L");
		o.insert("O");
		System.out.println(o.delMax());
		System.out.println(o.delMax());
		System.out.println(o.delMax());
		System.out.println(o.delMax());
		System.out.println(o.delMax());
		System.out.println(o.delMax());
	}

}
