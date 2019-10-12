package sorting;

public class QuickSort {
	
	public void sort(int[] arr, int l, int r) {
		if(l < r) {
			int p = partition (arr, l, r);
			sort(arr, l, p - 1);
			sort(arr, p + 1, r);
		}
	}

	private int partition(int[] arr, int l, int r) {
		int pivot = arr[l];
		int i = l+1;
		int j = r;
		while (true) {
			while (arr[i] < pivot) {
				i++;
				if (i == r) break;
			}
			while (arr[j] > pivot) {
				j--;
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

	public static void main(String[] args) {
		int[] arr = {4,2,6,8,4,2,6,7,3,1,5,7,1,4,6};
		MergeSort o = new MergeSort();
		o.sort(arr, 0, arr.length-1);
		for (int i: arr) {
			System.out.print(i + " ");
		}
	}

}
