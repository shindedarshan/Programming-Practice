package leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

	public int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c: s.toCharArray()) 
			map.merge(c, 1, Integer::sum);
		
		int ans = 0;
		
		for (Map.Entry<Character, Integer>e: map.entrySet()) {
			int v = e.getValue();
			ans += (v/2) * 2;
			if (ans % 2 == 0 && v % 2 == 1) ans++; //Take only one unique character in palindrome 
		}
		return ans;
    }

	public static void main(String[] args) {
		LongestPalindrome_409 o = new LongestPalindrome_409();
		String s = "abccccdd";
		System.out.println(o.longestPalindrome(s));
	}

}
