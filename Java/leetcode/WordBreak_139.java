package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_139 {

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0 || wordDict.isEmpty()) return false;
		
		int n = s.length();
		boolean[] mem = new boolean[n+1];
		mem[0] = true;
		
		for (int i = 1; i < n+1; i++) {
			for (String word: wordDict) {
				int m = word.length();
				if(i - m >= 0 ) {
					String st = s.substring(i-m, i);
					if (st.equals(word))
						mem[i] = mem[i - m];
				}
				if (mem[i]) break;
			}
		}
		return mem[n];
    }
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		WordBreak_139 o = new WordBreak_139();
		System.out.println(o.wordBreak(s, wordDict));
	}

}
