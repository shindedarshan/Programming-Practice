package sorting;

public class QuickSelect {

	public static void main(String[] args) {
		QuickSelect o = new QuickSelect();
		int[] arr = {4,2,6,8,4,2,6,7,3,1,5,7,1,4,6};
		System.out.println(o.select(arr, 5));
	}

	private int select(int[] arr, int i) {
		int l = 0; 
		int r = arr.length - 1; 
		while (l < r) {
			int p = partition(arr, l, r);
			if (p < i) l = p + 1;
			else if (p > i) r = p - 1;
			else return arr[p];
		}
		return arr[i];
	}

	private int partition(int[] arr, int l, int r) {
		int i = l;
		int j = r+1;
		while (true) {
			while (arr[++i] < arr[l]) {
				if (i == r) break;
			}
			while (arr[--j] > arr[l]) {
				if (j == l) break;
			}
			if (i >= j) break;
			swap(arr, i, j);
		}
		swap(arr, l ,j);
		return j;
	}

	private void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
