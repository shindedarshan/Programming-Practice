package leetcode.treesAndGraphs;

public class NumberOfIslands_200 {
	
	public int numIslands(char[][] grid) {
		int row = grid.length;
		if (row == 0) return 0;
		
		int col = grid[0].length;
		if (row == 1 && col == 1) {
			return valueOf(grid[0][0]);
		}
		boolean[][] visited = new boolean[row][col];
		int count = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					count++;
					dfs(grid, i, j, visited);
				}
			}
		}
		return count;
    }

	private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
		if (!inRange(i, 0, grid.length-1) || !inRange(j, 0, grid[0].length-1)) return;
		if (grid[i][j] == '0') return;
		if (visited[i][j]) return;
		visited[i][j] = true;
		dfs(grid, i, j-1, visited);
		dfs(grid, i, j+1, visited);
		dfs(grid, i-1, j, visited);
		dfs(grid, i+1, j, visited);
	}
	
	private boolean inRange(int val, int min, int max) {
		 return val >= min && val <= max;
	}

	private int valueOf(char c) {
		return Integer.parseInt(String.valueOf(c));
	}

	public static void main(String[] args) {
		NumberOfIslands_200 o = new NumberOfIslands_200();
		char[][] grid = {{'1','1','0','0','0'},
				        {'1','1','0','0','0'},
				        {'0','0','1','0','0'},
				        {'0','0','0','1','1'}};
		System.out.println(o.numIslands(grid));
	}

}
