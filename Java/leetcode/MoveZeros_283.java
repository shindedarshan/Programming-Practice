package leetcode;

public class MoveZeros_283 {
	
	public void moveZeroes(int[] arr) {
		if (arr.length < 2) return;
		int i = 0, j = 1;
		while (i < arr.length && j < arr.length) {
			if (arr[i] == 0 && arr[j] != 0) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
			if (arr[i] != 0 && arr[j] != 0) {
				i++; j++;
				continue;
			}
			if (arr[i] != 0) i++;
			if (arr[j] == 0) j++;
		}
    }

	public static void main(String[] args) {
		MoveZeros_283 o = new MoveZeros_283();
		int[] nums = {4,2,4,0,0,3,0,5,1,0};
		o.moveZeroes(nums);
		for (int i: nums) System.out.print(i + " ");
	}

}
