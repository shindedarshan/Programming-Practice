package sorting;

public class SelectionSort {

	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < min) {
					minIndex = j;
					min = arr[j];
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {4,2,6,3,5,8,9,2,3,4,1,2,3,1,1,8,5,6,4};
		// result:   1,1,1,2,2,2,3,3,3,4,4,4,5,5,6,6,8,8,9
		for (int i: sort(arr))
			System.out.print(i + " ");
	}
}
