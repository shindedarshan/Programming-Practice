package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		
		List<Integer> res = new ArrayList<>();
		
		boolean[][] visited = new boolean[r][c];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int x = 0, y = 0, di = 0;
		
		for (int i = 0; i < r * c; i++) {
			res.add(matrix[y][x]);
			visited[y][x] = true;
			
			int next_x = x + dx[di];
			int next_y = y + dy[di];
			
			if (next_x >= 0 && next_x < c && next_y >=0 && next_y < r && !visited[next_y][next_x]) {
				x = next_x;
				y = next_y;
			} else {
				di = (di + 1) % 4;
				x += dx[di];
				y += dy[di];
			}
		}
		
		return res;
    }

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		SpiralMatrix_54 o = new SpiralMatrix_54();
		for(int i: o.spiralOrder(matrix)) 
			System.out.print(i + " ");
	}

}
