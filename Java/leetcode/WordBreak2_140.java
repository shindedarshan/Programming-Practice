package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2_140 {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<String>();
		List<String> res = new ArrayList<>();
		Map<String, Boolean> out = helper(s, wordDict);
		for (Map.Entry<String, Boolean> e: out.entrySet()) {
			res.add(e.getKey().trim());
		}
		
		return res;
    }
	
	public Map<String, Boolean> helper(String s, List<String> wordDict) {
		HashMap<String, Boolean> outSt = new HashMap<>();
		if (s.length() == 0) {
			outSt.put("", true);
			return outSt;
		}
		int n = s.length();
		boolean[] mem = new boolean[n+1];
		mem[0] = true;

		for (int i = 1; i < n+1; i++) {
			mem[i] = false;
			for (String word: wordDict) {
				int m = word.length();
				if(i - m >= 0) {
					String st = s.substring(0, i);
					if (st.equals(word)) {
						mem[i] = mem[i-m]; 
						Map<String, Boolean> temp = helper(s.substring(i), wordDict);
						for (Map.Entry<String, Boolean> e: temp.entrySet()) {
							if (e.getValue() == true)
								outSt.put(word + " " + e.getKey(), e.getValue());
						}
					}
				}
			}
		}
		return outSt;
	}

	public static void main(String[] args) {
		String s = "pineapplepenapple";
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("pineapple");
		wordDict.add("pine");
		wordDict.add("applepen");
		wordDict.add("pen");
		wordDict.add("apple");
		
		WordBreak2_140 o = new WordBreak2_140();
		List<String> out = o.wordBreak(s, wordDict);
		
		for (String st: out) System.out.println(st);
	}

}
