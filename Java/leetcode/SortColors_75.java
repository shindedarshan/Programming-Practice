package leetcode;

public class SortColors_75 {
	
	public void sortColors(int[] nums) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        
        for(int i : nums ) {
        	if (i == 0) count_0++;
        	else if (i == 1) count_1++;
        	else count_2++;
        }
        
        int i = 0;
        while (i < nums.length) {
        	while (i < count_0) {
        		nums[i] = 0; i++;
        	}
        	while (i >= count_0 && i < count_1 + count_0) {
        		nums[i] = 1; i++;
        	}
        	
        	while (i >= count_0 + count_1 && i < count_0 + count_1 + count_2) {
        		nums[i] = 2; i++;
        	}
        }
    }

	public static void main(String[] args) {
		SortColors_75 o = new SortColors_75();
		int[] nums = {2, 0, 2, 1, 1, 0};
		o.sortColors(nums);
	}

}
