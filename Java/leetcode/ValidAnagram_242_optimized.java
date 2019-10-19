package leetcode;

public class ValidAnagram_242_optimized {

	public static void main(String[] args) {
		ValidAnagram_242 o = new ValidAnagram_242();
		String s = "aa";
		String t = "a";
		System.out.println(o.isAnagram(s, t));
	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] mem = new int[26];
		for (int i = 0; i < s.length(); i++) {
			mem[s.charAt(i) - 'a']++;
			mem[t.charAt(i) - 'a']--;
		}
		for (int c: mem) if(c != 0) return false;
		return true;
	}

}
