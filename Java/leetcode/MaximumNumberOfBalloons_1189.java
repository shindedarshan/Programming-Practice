package leetcode;

public class MaximumNumberOfBalloons_1189 {
	
	public int maxNumberOfBalloons(String text) {
		int[] mem = new int[26];
		for (char c: text.toCharArray()) mem[c - 'a'] += 1;
		
		mem['l' - 'a'] /= 2;
		mem['o' - 'a'] /= 2;
		return Math.min(mem['a'-'a'], Math.min(mem['b'-'a'], Math.min(mem['l' - 'a'], Math.min(mem['o'-'a'], mem['n'-'a']))));
    }

	public static void main(String[] args) {
		String text = "loonbalxballpoon";
		MaximumNumberOfBalloons_1189 o = new MaximumNumberOfBalloons_1189();
		System.out.println(o.maxNumberOfBalloons(text));
	}

}
