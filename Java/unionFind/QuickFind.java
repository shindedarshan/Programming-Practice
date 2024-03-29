package unionFind;

public class QuickFind {
	int[] list;
	
	public QuickFind(int n) {
		this.list = new int[n];
		for (int i = 0; i < n; i++) this.list[i] = i;
	}
	
	public boolean connected(int s, int t) {
		return this.list[s] == this.list[t];
	}
	
	public void union(int s, int t) {
		int indexS = this.list[s];
		int indexT = this.list[t];
		
		for (int i = 0; i < this.list.length; i++) {
			if(this.list[i] == indexS) this.list[i] = indexT;
		}
	}
	
	public static void main(String[] args) {
		QuickFind uf = new QuickFind(10);
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		System.out.println(uf.connected(0, 7));
		System.out.println(uf.connected(8, 9));
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		uf.union(1, 0);
		System.out.println(uf.connected(0, 7));
	}
}
