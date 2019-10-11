package unionFind;

import java.net.ConnectException;

public class QuickUnionWithImprovement {
	int[] list, size;
	
	public QuickUnionWithImprovement(int n) {
		list = new int[n];
		size = new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = i;
			size[i] = 1;
		}
	}
	
	public boolean connected(int s, int t) {
		return findRoot(s) == findRoot(t);
	}

	private int findRoot(int i) {
		while (list[i] != i) i = list[i];
		return i;
	}
	
	public void union(int s, int t) {
		if (size[s] < size[t]) connect(s, t);
		else connect(t, s);
	}

	private void connect(int i, int j) {
		int rootI = findRoot(i);
		int rootJ = findRoot(j);
		for (int p = 0; p < this.list.length; p++) {
			if (list[p] == rootI) list[p] = rootJ;
		}
	}
	
	public static void main(String[] args) {
		QuickUnionWithImprovement o = new QuickUnionWithImprovement(10);
		o.union(4, 3);
		o.union(3, 8);
		o.union(6, 5);
		o.union(9, 4);
		o.union(2, 1);
		o.union(5, 0);
		o.union(7, 2);
		System.out.println(o.connected(1, 9));
		o.union(6, 1);
		o.union(7, 3);
		System.out.println(o.connected(1, 9));
	}
}
