package leetcode;

public class SortColors_75_single_pass {
	
	public void sortColors(int[] nums) {
		int i = 0, j = nums.length - 1, n = 0;
		
		while (n < nums.length) {
			if (nums[n] == 2 && n < j) {
				swap(nums, n, j); 
				j--;
			}
			else if (nums[n] == 0 && n > i) {
				swap(nums, n, i);
				i++;
			}
			else n++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		SortColors_75_single_pass o = new SortColors_75_single_pass();
		int[] nums = {2,0,2,1,1,0};
		o.sortColors(nums);
		for (int i : nums) System.out.print(i + " ");
	}

}
