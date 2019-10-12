package priorityQueue;

public class PriorityQueueUsingHeap {
	
	String[] pq;
	int n;
	
	public PriorityQueueUsingHeap() { 
		pq = new String[1];
		n = -1;
	}
	
	public void insert(String s) {
		if (isEmpty()) {
			pq[++n] = s;
		} else {
			if (++n == pq.length) expand();
			pq[n] = s;
			swim();
		}
	}
	
	public String delMax() {
		if (isEmpty()) {
			System.out.println("Underflow: Priority queue is empty.");
			return "";
		}
		String data = pq[0];
		swap(0, n);
		pq[n--] = null;
		sink();
		if (n < pq.length/4) shrink();
		return data;
	}
	
	private void swim() {
		int temp = n;
		while (temp > 0) {
			if (pq[temp].compareTo(pq[(temp-1)/2]) > 0) {
				swap(temp, (temp-1)/2);
				temp = (temp-1)/2;
			}
			else break;
		}
	}
	
	private void sink() {
		int temp = 0;
		while (true) {
			if ((temp+1) * 2 <= n && pq[temp].compareTo(pq[(temp+1) * 2]) < 0 && pq[temp].compareTo(pq[((temp+1) * 2)-1]) < 0) {
				if(pq[(temp+1) * 2].compareTo(pq[((temp+1) * 2)-1]) < 0) swap(temp, ((temp+1) * 2)-1);
				else swap(temp, (temp+1) * 2);
			} else if((temp+1) * 2 <= n && pq[temp].compareTo(pq[(temp+1) * 2]) < 0) swap(temp, (temp+1) * 2);
			else if (((temp+1) * 2)-1 <= n && pq[temp].compareTo(pq[((temp+1) * 2)-1]) < 0) swap(temp, ((temp+1) * 2)-1);
			else break;
		}
	}

	public boolean isEmpty() {
		return n == -1;
	}
	
	public void expand() {
		String[] newPQ = new String[pq.length * 2];
		for (int i = 0; i < pq.length; i++) newPQ[i] = pq[i];
		pq = newPQ;
	}
	
	public void shrink() {
		String[] newPQ = new String[pq.length / 2];
		for (int i = 0; i < n; i++) newPQ[i] = pq[i];
		pq = newPQ;
	}
	
	public void swap(int i, int j) {
		String t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	public static void main(String[] args) {
		PriorityQueueUsingHeap o = new PriorityQueueUsingHeap();
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
