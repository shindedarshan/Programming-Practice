package leetcode;

import java.util.HashMap;

public class TwoSum_1 {
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> mem = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (mem.containsKey(nums[i])) return new int[] {mem.get(nums[i]), i};
			else mem.put(target - nums[i], i);
		}
		return null;
    }

	public static void main(String[] args) {
		TwoSum_1 o = new TwoSum_1();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] out = o.twoSum(nums, target);
		for (int i: out) System.out.print(i + " ");
	}

}
