package leetcode.dynamicProgramming;

public class LongestPalindromicSubsequence_516 {
	
	public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int n = s.length();
		int[][] mem = new int[n][n];
		
		for (int i = n-1; i >= 0; i--) {
			mem[i][i] = 1;
			for (int j = i+1; j < n; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					mem[i][j] = 2 + mem[i+1][j-1];
				}
				else {
					mem[i][j] = Math.max(mem[i+1][j], mem[i][j-1]);
				}
			}
		}
		return mem[0][n-1];
    }

	public static void main(String[] args) {
		LongestPalindromicSubsequence_516 o = new LongestPalindromicSubsequence_516();
		String s = "bbbab";
		System.out.println(o.longestPalindromeSubseq(s));
	}

}
