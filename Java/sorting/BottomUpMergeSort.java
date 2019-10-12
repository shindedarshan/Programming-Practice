package sorting;

public class BottomUpMergeSort {

	public static void main(String[] args) {
		int[] arr = {4,2,6,8,4,2,6,7,3,1,5,7,1,4,6};
		BottomUpMergeSort o = new BottomUpMergeSort();
		o.sort(arr, 0, arr.length-1);
		for (int i: arr) {
			System.out.print(i + " ");
		}
	}

	private void sort(int[] arr, int l, int r) {
		for (int j = 1; j <= Math.log10(arr.length)/Math.log10(2) + 1; j++) { 
			int width = (int) Math.pow(2, j);
			for (int i = 0; i < arr.length; i += width) {
				int left = i;
				int right = i + width - 1;
				if (right >= arr.length) right = arr.length - 1;
				int mid = (left + right)/2;
				merge(arr, left, mid, right);
			}
		}
	}

	private void merge(int[] arr, int left, int mid, int right) {
		if (left == right) return;
		int[] aux = new int[right - left + 1];
		int i = left; 
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				aux[k] = arr[i];
				i++; k++;
			}
			else {
				aux[k] = arr[j];
				j++; k++;
			}
		}
		while (i <= mid) {
			aux[k] = arr[i]; 
			i++; k++;
		}
		while (j <= right) {
			aux[k] = arr[j]; 
			j++; k++;
		}
		
		for (i = left, k = 0; k < aux.length; i++, k++) arr[i] = aux[k];
	}

}
