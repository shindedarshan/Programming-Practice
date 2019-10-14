package leetcode;

public class JumpGame2_45 {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		JumpGame2_45 o = new JumpGame2_45();
		System.out.println(o.jump(nums));
	}
	
	public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        
        int[] jumps = new int[n];
        jumps[0] = 0;
        
        for (int i = 1; i < n; i++)
        	jumps[i] = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
        	for (int j = 1; j <= nums[i]; j++) {
        		if (i + j  < n) {
        			if (jumps[i] != Integer.MAX_VALUE)
        				jumps[i+j] = Math.min(jumps[i+j], jumps[i] + 1);
        		}
        	}
        }
        return jumps[n-1];
    }
}
