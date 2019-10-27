package leetcode.dynamicProgramming;

public class LongestCommonSubsequence_1143 {
	
	public int longestCommonSubsequence(String t1, String t2) {
		if (t1 == null || t2 == null) return 0;
		if (t1.length() == 0 || t2.length() == 0) return 0;
		
		int m = t1.length();
		int n = t2.length();
		
		int[][] mem = new int[m+1][n+1];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (t1.charAt(i) == t2.charAt(j)) 
					mem[i+1][j+1] = 1 + mem[i][j];
				else 
					mem[i+1][j+1] = Math.max(mem[i+1][j], mem[i][j+1]);
			}
		}
		
		return mem[m][n];
    }

	public static void main(String[] args) {
		LongestCommonSubsequence_1143 o = new LongestCommonSubsequence_1143();
		String s1 = "";
		String s2 = "";
		System.out.println(o.longestCommonSubsequence(s1, s2));
	}

}
