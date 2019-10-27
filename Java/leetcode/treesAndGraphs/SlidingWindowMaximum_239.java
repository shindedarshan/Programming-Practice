package leetcode.treesAndGraphs;

import java.util.Collections;
import java.util.TreeMap;

public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int resultLen = len-k+1;
        int[] result = new int[resultLen];
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int i = 0; i < resultLen; i++){
            int maxNum = map.firstKey();
            result[i] = maxNum;
            
            if(i < resultLen-1) {
                int currentFront = nums[i];
                int currentCount = map.get(currentFront);
                if(currentCount == 1) map.remove(currentFront);
                else {
                    map.put(currentFront, currentCount-1);
                }
                int nextTail = nums[i+k];
                map.put(nextTail, map.getOrDefault(nextTail, 0) + 1);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,3,-1,-3,5,3,6,7}; 
    	int k = 3;
    	SlidingWindowMaximum_239 o = new SlidingWindowMaximum_239();
    	int[] res = o.maxSlidingWindow(nums, k);
    	for (int i: res)
    		System.out.print(i + " ");
    }
}
