package leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ValidAnagram_242 {
	
	public boolean isAnagram(String s, String t) {
		if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) return true;
		if ((s == null || s.length() == 0) || (t == null || t.length() == 0)) return false;
		Map<Character, Integer> sMap = getFreqMap(s);
		Map<Character, Integer> tMap = getFreqMap(t);
		return isSame(sMap, tMap);
    }

	private boolean isSame(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
		Set<Character> sSet = sMap.keySet();
		Set<Character> tSet = tMap.keySet();
		
		if (sSet.size() != tSet.size()) return false;
		
		Iterator<Character> is = sSet.iterator();
		Iterator<Character> it = tSet.iterator();
		
		for (int i = 0, j = 0; i < sSet.size() && j < tSet.size(); i++,j++) {
			char sKey = is.next();
			char tKey = it.next();
			if (sKey == tKey) {
				int sVal = sMap.get(sKey);
				int tVal = tMap.get(tKey);
				if (sVal == tVal) continue;
				else return false;
			}
			else return false;
		}
		
		return true;
	}

	private Map<Character, Integer> getFreqMap(String t) {
		Map<Character, Integer> freq = new TreeMap<>();
		for (char c: t.toCharArray()) {
			if (freq.containsKey(c)) freq.put(c, freq.get(c) + 1);
			else freq.put(c, 1);
		}
		return freq;
	}

	public static void main(String[] args) {
		ValidAnagram_242 o = new ValidAnagram_242();
		String s = "aa";
		String t = "a";
		System.out.println(o.isAnagram(s, t));
	}

}
