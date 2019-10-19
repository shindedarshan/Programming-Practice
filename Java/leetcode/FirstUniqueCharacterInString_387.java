package leetcode;

import java.util.HashMap;

public class FirstUniqueCharacterInString_387 {
	
	public int firstUniqChar(String s) {
		HashMap<Character, Boolean> mem = new HashMap<>();
		char[] ch = s.toCharArray();
		
		for (char c: ch) {
			if (mem.containsKey(c)) {
				mem.put(c, true);
			}
			else {
				mem.put(c, false);
			}
		}
		
		for (int i = 0; i < ch.length; i++) {
			if (!mem.get(ch[i])) return i;
		}
		return -1;
    }
	
	public static void main(String[] args) {
		FirstUniqueCharacterInString_387 o = new FirstUniqueCharacterInString_387();
		String s = "loveleetcode";
		System.out.println(o.firstUniqChar(s));
	}

}
