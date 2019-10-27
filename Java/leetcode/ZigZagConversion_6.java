package leetcode;

public class ZigZagConversion_6 {
	
	public String convert(String s, int n) {
		if (n <= 1 || n > s.length()) return s;
		int[] diff = {n + (n-2), 0};
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int t = i, j = 0;
			sb.append(s.charAt(t));
			while (t < s.length()) {
				if (diff[j%2] == 0) j++;
				t += diff[j%2];
				if (t < s.length())
					sb.append(s.charAt(t));
				j++;
			}
			diff[0] -= 2;
			diff[1] += 2;
		}
		return sb.toString();
    }

	public static void main(String[] args) {
		ZigZagConversion_6 o = new ZigZagConversion_6();
		String s = "PAYPALISHIRING";
		int n = 4;
		System.out.println(o.convert(s, n));
	}

}
