package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2_140_optimized {
	int min, max;
	List<String> res;
	Set<String> dict;
	List<String>[] map;

	public static void main(String[] args) {
		String s = "catsanddog";
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		WordBreak2_140_optimized o = new WordBreak2_140_optimized();
		List<String> out = o.wordBreak(s, wordDict);
		
		for (String st: out) System.out.println(st);
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		res = new ArrayList<String>();
		dict = new HashSet<String>();
		map = new List[s.length()];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		for (String word: wordDict) {
			min = Math.min(min, word.length());
			max = Math.max(max, word.length());
			dict.add(word);
		}
		
		List<String> l2 = backtrack(s, 0);
		
		for (String st: l2) res.add(st.trim());
		
		return res;
	}

	private List<String> backtrack(String s, int idx) {
		if (idx == s.length()) {
			List<String> li = new ArrayList<>();
			li.add("");
			return li;
		}
		
		if (map[idx] != null) return map[idx];
		
		List<String> li = new ArrayList<>();
		
		for (int i = idx + min; i <= idx + max && i <= s.length(); i++) {
			String st = s.substring(idx, i);
			if (dict.contains(st)) {
				List<String> next = backtrack(s, i);
				for (String ss: next) li.add(st + " " + ss);
			}
		}
		map[idx] = li;
		return li;
	}
}
