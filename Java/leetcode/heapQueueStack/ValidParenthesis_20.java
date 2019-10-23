package leetcode.heapQueueStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesis_20 {
	static HashMap<Character, Character> h = null;	
	static {
		h = new HashMap<>();
		h.put('(', ')');
		h.put('[', ']');
		h.put('{', '}');
	}
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		Set<Character> ch = new HashSet<>();
		ch.add(']');
		ch.add('}');
		ch.add(')');
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (ch.contains(c)) {
				if (h.get(st.pop()) != c) return false;
			} else {
				st.push(c);
			}
		}
		return st.isEmpty();
    }

	public static void main(String[] args) {
		ValidParenthesis_20 o = new ValidParenthesis_20();
		String st = "{]";
		System.out.println(o.isValid(st));
	}

}
