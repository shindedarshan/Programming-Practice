package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int maxLen = 1;
		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		for (; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
				maxLen = Math.max(maxLen, i - start);
				start = map.get(s.charAt(i)) + 1;
			} 
			map.put(s.charAt(i), i);
		}
		
		return Math.max(maxLen,i - start);
    }

	public static void main(String[] args) {
		String s = "aab";
		LongestSubstringWithoutRepeatingCharacters_3 o = new LongestSubstringWithoutRepeatingCharacters_3();
		System.out.println(o.lengthOfLongestSubstring(s));
	}

}
