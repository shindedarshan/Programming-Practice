package leetcode.treesAndGraphs;

import java.util.Stack;

public class DecodeString_394 {
	
	public String decodeString(String s) {
		if (s == null || s.length() == 0) return s;
		Stack<String> st = new Stack<>();
		String str = "";
		int i = 0;
		
		while (i < s.length()) {
			if (i < s.length() && Character.isDigit(s.charAt(i))) {
				String num = "";
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num += s.charAt(i);
					i++;
				}
				st.push(num);
			}
			
			if (i < s.length() && Character.isLetter(s.charAt(i))) {
				str = "";
				while (i < s.length() && Character.isLetter(s.charAt(i))) {
					str += s.charAt(i);
					i++;
				}
				st.push(str);
			}
			
			if (i < s.length() && s.charAt(i) == '[') {
				st.push("[");
				i++;
			}
			
			if (i < s.length() && s.charAt(i) == ']') {
				str = st.pop();
				while (!st.isEmpty() && !st.peek().equals("[")) {
					str = st.pop() + str;
				}
				
				if (!st.isEmpty() && st.peek().equals("["))
					st.pop();
				
				int num = Integer.parseInt(st.pop());
				str = repeatString(str, num);
				st.push(str);
				i++;
			}
		}
		str = "";
		while (!st.isEmpty()) {
			str = st.pop() + str;
		}
		return str;
    }

	private String repeatString(String str, int num) {
		StringBuilder sb = new StringBuilder(str.length() * num);
		for (int i = 0; i < num; i++)
			sb.append(str);
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeString_394 o = new DecodeString_394();
		String s = "3[a2[c]]";
		System.out.println(o.decodeString(s));
	}

}
