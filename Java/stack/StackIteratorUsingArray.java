package stack;

import java.util.Iterator;

public class StackIteratorUsingArray implements Iterator<Integer> {
	int[] list;
	int n, curr;
	
	public StackIteratorUsingArray(int[] list, int curr) {
		this.list = list;
		this.curr = curr;
	}

	@Override
	public boolean hasNext() {
		if (this.curr >= 0) return true;
		return false;
	}

	@Override
	public Integer next() {
		int val = this.list[this.curr];
		this.curr--;
		return val;
	}

}
