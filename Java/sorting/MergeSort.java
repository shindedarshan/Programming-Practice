package sorting;

public class MergeSort {
	
	public void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}

	private void merge(int[] arr, int l, int m, int r) {
		int[] aux = new int[r - l + 1];
		int i = l; 
		int j = m+1;
		int k = 0;
		
		while (i <= m && j <= r) {
			if(arr[i] <= arr[j]) {
				aux[k] = arr[i];
				i++; k++;
			}
			else {
				aux[k] = arr[j];
				j++; k++;
			}
		}
		while (i <= m) {
			aux[k] = arr[i];
			i++; k++;
		}
		while (j <= r) {
			aux[k] = arr[j];
			j++; k++;
		}
		for (i = l, k = 0; i <= r; i++, k++) {
			arr[i] = aux[k];
		}
	}

	public static void main(String[] args) {
		int[] arr = {4,2,6,8,4,2,6,7,3,1,5,7,1,4,6};
		MergeSort o = new MergeSort();
		o.sort(arr, 0, arr.length-1);
		for (int i: arr) {
			System.out.print(i + " ");
		}
	}

}
