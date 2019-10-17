package leetcode;

public class SpiralMatrix2_59 {
	
	public int[][] generateMatrix(int n) {
		if (n <= 0) return new int[0][0];
		
		int[][] out = new int[n][n];
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int x = 0, y = 0, di = 0;
		
		for(int i = 1; i <= n*n; i++) {
			out[y][x] = i;
			
			int next_x = x + dx[di];
			int next_y = y + dy[di];
			
			if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n && out[next_y][next_x] == 0) {
				x = next_x;
				y = next_y;
			} else {
				di = (di + 1) % 4;
				x += dx[di];
				y += dy[di];
			}
		}
		
		return out;
    }

	public static void main(String[] args) {
		SpiralMatrix2_59 o = new SpiralMatrix2_59();
		int n = 3;
		int[][] out = o.generateMatrix(n);
		for (int[] i: out) {
			for (int j: i) System.out.print(j + " ");
			System.out.println();
		}
	}

}
