package leetcode;

public class StringCompression_443 {
	
	public int compress(char[] chars) {
		int anchor = 0, write = 0;
		
		for (int read = 0; read < chars.length; read++) {
			if (anchor == read) chars[write++] = chars[anchor];
			if (read != chars.length - 1 && chars[read] == chars[read + 1]) {
				while (read < chars.length - 1 && chars[read] == chars[read + 1]) read++;
				if (read > anchor) {
					for(char c: ("" + (read - anchor + 1)).toCharArray()) {
						chars[write++] = c;
					}
				}
			}
			anchor = read + 1;
		}
		return write;
	}

	public static void main(String[] args) {
		StringCompression_443 o = new StringCompression_443();
		char[] chars = {'a','a','b','b','b','a','c','c'};
		System.out.println(o.compress(chars));
	}

}
