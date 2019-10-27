package leetcode;

public class SubarraySumEqualsK_560 {

	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int count = 0;
		
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum += nums[end];
				if (sum == k) count++;
			}
		}
		return count;
    }

	public static void main(String[] args) {
		SubarraySumEqualsK_560 o = new SubarraySumEqualsK_560();
		int[] nums = {1,1,1};
		int k = 1;
		System.out.println(o.subarraySum(nums, k));
	}

}
