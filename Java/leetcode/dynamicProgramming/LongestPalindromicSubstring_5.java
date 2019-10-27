package leetcode.dynamicProgramming;

public class LongestPalindromicSubstring_5 {
	
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return "";
		
		int n = s.length();
		
		boolean[][] dp = new boolean[n][n];
		
		int maxLen = 0, maxStart = 0;
		
		for (int end = 0; end < n; end++) {
			for (int start = 0; start <= end; start++) {
				if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) 
					dp[start][end] = true;
				if (dp[start][end] && maxLen < end - start + 1) {
					maxLen = end - start + 1;
					maxStart = start;
				}
			}
		}
		return s.substring(maxStart, maxStart + maxLen);
    }

	public static void main(String[] args) {
		LongestPalindromicSubstring_5 o = new LongestPalindromicSubstring_5();
		String s = "cbbd";
		System.out.println(o.longestPalindrome(s));
	}

}
