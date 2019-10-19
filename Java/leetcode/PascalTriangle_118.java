package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
	
	public List<List<Integer>> generate(int n) {
		List<List<Integer>> out = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			List<Integer> li = new ArrayList<>();
			for (int j = 0; j < i; j++) li.add(1);
			if (i > 2) {
				for(int j = 1; j < i-1; j++)
					li.set(j, out.get(i-2).get(j-1) + out.get(i-2).get(j));
			}
			out.add(li);
		}
		return out;
    }

	public static void main(String[] args) {
		PascalTriangle_118 o = new PascalTriangle_118();
		o.generate(5);
	}

}
