package leetcode.sortingSearching;

public class MedianOfTwoSortedArrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = (nums1 == null)? 0 : nums1.length;
		int n = (nums1 == null)? 0 : nums2.length;
		int med = ((m+n)%2 == 0) ? ((m+n)/2) + 1 : (m+n+1)/2;
		int[] temp = new int[med];
		int i = 0, x = 0, y= 0;
		while (i < med) {
			if (x < m && y < n) {
				if (nums1[x] < nums2[y]) {
					temp[i] = nums1[x];
					i++; x++;
				} else {
					temp[i] = nums2[y];
					i++; y++;
				}
			} else {
				if (x < m) {
					temp[i] = nums1[x];
					i++; x++;
				}
				else {
					temp[i] = nums2[y];
					i++; y++;
				}
			}
		}
		if ((m+n)%2 == 0) {
			return (temp[--med] + temp[--med])/2.0;
		}
		else {
			return temp[--med];
		}
    }
	public static void main(String[] args) {
		MedianOfTwoSortedArrays_4 o = new MedianOfTwoSortedArrays_4();
		int[] nums1 = {};
		int[] nums2 = {2};
		System.out.println(o.findMedianSortedArrays(nums1, nums2));
	}

}
