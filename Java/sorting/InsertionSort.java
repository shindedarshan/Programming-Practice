package sorting;

public class InsertionSort {
	
	public static int[] sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j >= 1; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
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
