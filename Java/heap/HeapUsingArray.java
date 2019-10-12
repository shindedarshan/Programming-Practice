package heap;

public class HeapUsingArray {
	String[] heap;
	int cur = -1;
	
	public HeapUsingArray() {
		this.heap = new String[1];
	}
	
	public void insert(String s) {
		cur++;
		if (cur >= this.heap.length)
			expand();
		heap[cur] = s;
		swim();
	}
	
	private void swim() {
		int temp = cur;
		while (temp > 0) {
			if (heap[(temp-1)/2].compareTo(heap[temp]) < 0) {
				swap(this.heap, (temp-1)/2, temp);
				temp = (temp-1)/2;
			}
			else break;
		}
	}

	public boolean isEmpty() {
		return cur == -1;
	}
	
	public String delMax() {
		if (isEmpty()) {
			System.out.println("Underflow: Heap is empty.");
			return "";
		}
		String data = this.heap[0];
		swap(this.heap, 0, cur);
		this.heap[cur] = "";
		cur--;
		sink();
		return data;
	}
	
	private void sink() {
		int temp = 0;
		while ((temp <= cur && (temp + 1)*2 <= cur) && (heap[temp].compareTo(heap[(temp + 1)*2]) < 0 || heap[temp].compareTo(heap[((temp + 1)*2) - 1]) < 0)) {
			if (heap[(temp + 1)*2].compareTo(heap[((temp + 1)*2) - 1]) < 0) {
				swap(this.heap, temp, ((temp + 1)*2) - 1);
				temp = ((temp + 1)*2) - 1;
			}
			else {
				swap(this.heap, temp, (temp + 1)*2);
				temp = (temp + 1)*2;
			}
		}
	}

	private void swap(String[] heap, int i, int j) {
		String t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

	public void expand() {
		String[] newHeap = new String[this.heap.length * 2];
		for (int i = 0; i < this.heap.length; i++) {
			newHeap[i] = this.heap[i];
		}
		this.heap = newHeap;
	}

	public static void main(String[] args) {
		HeapUsingArray o = new HeapUsingArray();
		o.insert("D");
		o.insert("A");
		o.insert("R");
		o.insert("S");
		o.insert("H");
		o.insert("A");
		o.insert("N");
		System.out.println(o.isEmpty());
		System.out.println(o.delMax());
		System.out.println(o.delMax());
		System.out.println(o.delMax());
	}

}
