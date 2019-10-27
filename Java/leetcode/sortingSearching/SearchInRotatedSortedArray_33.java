package leetcode.sortingSearching;

public class SearchInRotatedSortedArray_33 {

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		while(low <= high) {
			int mid = (low + high)/2;
			if (target == nums[mid]) return mid;
			if (nums[mid] <= nums[high]) {
				if (nums[mid] < target && target <= nums[high])
					low = mid + 1;
				else 
					high = mid - 1;
			} else {
				if (nums[low] <= target && target < nums[mid])
					high = mid - 1;
				else 
					low = mid + 1;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		SearchInRotatedSortedArray_33 o = new SearchInRotatedSortedArray_33();
		int[] arr = {3,5,1};
		int x = 3;
		System.out.println(o.search(arr, x));
	}

}
