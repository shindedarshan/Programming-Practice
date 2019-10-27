package leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_139 {

	public static void main(String[] args) {
		WordBreak_139 o = new WordBreak_139();
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(o.wordBreak(s, wordDict));
	}

	private boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) return false; 
		
		int n = s.length();
		boolean[] mem = new boolean[n+1];
		mem[0] = true;
		for (int i = 1; i <= n; i++) {
			for (String word: wordDict) {
				int m = word.length();
				if (i-m >= 0) {
					String st = s.substring(i-m, i);
					if (st.equals(word)) {
						mem[i] = mem[i-m];
					}
				}
				if (mem[i]) break;
			}
		}
		return mem[n];
	}

}
