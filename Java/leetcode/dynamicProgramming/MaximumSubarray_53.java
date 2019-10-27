package leetcode.dynamicProgramming;

public class MaximumSubarray_53 {
	
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) 
			return 0;
		
		return maxSubArraySum(nums, 0, nums.length-1);
    }

	private int maxSubArraySum(int[] arr, int low, int high) {
		if (low == high)
			return arr[low];
		
		int mid = (low + high) / 2;
		
		return Math.max(maxSubArraySum(arr, low, mid), 
				        Math.max(maxSubArraySum(arr, mid + 1, high), 
				        		 maxSubArrayCrossingSum(arr, low, mid, high)));
	}

	private int maxSubArrayCrossingSum(int[] arr, int low, int mid, int high) {
		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		for (int i = mid; i >= low; i--) {
			sum += arr[i];
			if (sum > leftSum) leftSum = sum;
		}
		
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if (sum > rightSum) rightSum = sum;
		}
		return leftSum + rightSum;
	}

	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray_53 o = new MaximumSubarray_53();
		System.out.println(o.maxSubArray(arr));
	}

}
