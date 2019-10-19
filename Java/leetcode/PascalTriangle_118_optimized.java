package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118_optimized {
	
	public List<List<Integer>> generate(int n) {
		List<List<Integer>> triangle =  new ArrayList<List<Integer>>();
		
		if(n == 0) return triangle;
		
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);
		
		for (int i = 1; i < n; i++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prev = triangle.get(i-1);
			
			row.add(1);
			
			for(int j = 1; j < i; j++) {
				row.add(prev.get(j-1) + prev.get(j));
			}
			row.add(1);
			triangle.add(row);
		}
		
		return triangle;
	}

	public static void main(String[] args) {
		PascalTriangle_118_optimized o = new PascalTriangle_118_optimized();
		o.generate(5);
	}

}
