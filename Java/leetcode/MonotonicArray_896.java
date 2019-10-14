package leetcode;

public class MonotonicArray_896 {

	public static void main(String[] args) {
		MonotonicArray_896 o = new MonotonicArray_896();
		int[] A = {1,3,2};
		System.out.println(o.isMonotonic(A));
	}
	
	public boolean isMonotonic(int[] A) {
		int n = A.length;
		if (n <= 2) return true;
		else {
			int i = 0;
			while (i < n-2 && A[i] == A[i+1]) i++;
			boolean flag = A[i+1] > A[i];
			if (flag) {
				while (i < n-1) {
					if (A[i+1] >= A[i]) i++;
					else return false;
				}
			}
			while (i < n-1) {
				if (A[i+1] <= A[i]) i++;
				else return false;
			}
		}
		return true;
    }
}
