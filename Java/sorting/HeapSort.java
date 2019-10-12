package sorting;

public class HeapSort {
	
	String[] pq;
	int n;
	
	public String delMax() {
		if (isEmpty()) {
			System.out.println("Underflow: Priority queue is empty.");
			return "";
		}
		String data = pq[0];
		swap(0, n--);
		sink();
		return data;
	}
	
	private void sink() {
		int temp = 0;
		while (true) {
			if ((temp+1) * 2 <= n && pq[temp].compareTo(pq[(temp+1) * 2]) < 0 && pq[temp].compareTo(pq[((temp+1) * 2)-1]) < 0) {
				if(pq[(temp+1) * 2].compareTo(pq[((temp+1) * 2)-1]) < 0) {
					swap(temp, ((temp+1) * 2)-1);
					temp = ((temp+1) * 2)-1;
				}
				else {
					swap(temp, (temp+1) * 2);
					temp = (temp+1) * 2;
				}
			} else if((temp+1) * 2 <= n && pq[temp].compareTo(pq[(temp+1) * 2]) < 0) {
				swap(temp, (temp+1) * 2);
				temp = (temp+1) * 2;
			}
			else if (((temp+1) * 2)-1 <= n && pq[temp].compareTo(pq[((temp+1) * 2)-1]) < 0) {
				swap(temp, ((temp+1) * 2)-1);
				temp = ((temp+1) * 2)-1;
			}
			else break;
		}
	}

	public boolean isEmpty() {
		return n == -1;
	}
	
	public void swap(int i, int j) {
		String t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	public void sort(String[] arr) {
		this.pq = arr;
		this.n = arr.length - 1;
		heapify();
		for(int i = 0; i < arr.length; i++) {
			delMax();
		}
	}
	
	private void heapify() {
		int temp = n;
		for (int i = 0; i <= temp; i++) {
			this.n = i;
			swim();
		}
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

	public static void main(String[] args) {
		HeapSort o = new HeapSort();
		String[] arr = {"D","A","R","S","H","A","N"};
		o.sort(arr);
		for (String s: arr)
			System.out.print(s + " ");
	}

}
