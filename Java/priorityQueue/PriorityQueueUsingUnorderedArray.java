package priorityQueue;

public class PriorityQueueUsingUnorderedArray {
	
	String[] pq;
	int n;
	
	public PriorityQueueUsingUnorderedArray() {
		n = -1;
		pq = new String[1];
	}
	
	public void insert(String s) {
		if (isEmpty()) {
			pq[++n] = s;
			return;
		}
		if (++n == pq.length) expand();
		pq[n] = s;
	}
	
	public boolean isEmpty() {
		return n == -1;
	}
	
	public String delMax() { 
		if (isEmpty()) {
			System.out.println("Underflow: Priority queue is empty.");
			return "";
		}
		int i = findMax();
		String data = pq[i];
		shift(i, n--);
		pq[n+1] = null;
		if (n < pq.length/4) shrink();
		return data;
	}
	
	private int findMax() {
		String maxC = pq[0];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (pq[i].compareTo(maxC) > 0) {
				maxC = pq[i];
				max = i;
			}
		}
		return max;
	}

	private void shift(int p, int q) {
		for (int i = p; i < q; i++) {
			pq[i] = pq[i+1];
		}
	}

	private void expand() {
		String[] newPQ = new String[pq.length * 2];
		for (int i = 0; i < pq.length; i++) newPQ[i] = pq[i];
		pq = newPQ;
	}
	
	private void shrink() {
		String[] newPQ = new String[pq.length/2];
		for (int i = 0; i < newPQ.length; i++) {
			if (i <= n) newPQ[i] = pq[i];
			else newPQ[i] = "";
		}
		pq = newPQ;
	}
	
	public static void main(String[] args) {
		PriorityQueueUsingUnorderedArray o = new PriorityQueueUsingUnorderedArray();
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
