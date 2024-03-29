package unionFind;

public class QuickUnion {
	int[] list;
	
	public QuickUnion(int n) {
		this.list = new int[n];
		
		for (int i = 0; i < n; i++) this.list[i] = i;
	}
	
	public boolean find(int s, int t) {
		return findRoot(s) == findRoot(t);
	}
	
	private int findRoot(int i) {
		while (i != this.list[i]) i = this.list[i];
		return i;
	}

	public void union(int s, int t) {
		int rootS = findRoot(s);
		int rootT = findRoot(t);
		list[rootS] = rootT;
	}
	
	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		qu.union(4, 3);
		qu.union(9, 8);
		qu.union(3, 8);
		qu.union(5, 0);
		qu.union(2, 1);
		qu.union(0, 1);
		qu.union(6, 5);
		qu.union(7, 1);
		System.out.println(qu.find(5, 4));
		qu.union(1, 8);
		System.out.println(qu.find(6, 9));
	}
}
