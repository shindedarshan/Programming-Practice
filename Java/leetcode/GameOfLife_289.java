package leetcode;

class GameOfLife_289 {
    public void gameOfLife(int[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0) return;
        int[][] nei = getNieghbors(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (nei[i][j] < 2 || nei[i][j] > 3) board[i][j] = 0;
                if (board[i][j] == 0 && nei[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    
    private int[][] getNieghbors(int[][] board) {
        int[][] nei = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;
                if (i > 0 && j > 0 && board[i-1][j-1] == 1) count++;
                if (i > 0 && board[i-1][j] == 1) count++;
                if (i > 0 && j < board[i].length-1 && board[i-1][j+1] == 1) count++;
                if (j > 0 && board[i][j-1] == 1) count++;
                if (j < board[i].length-1 && board[i][j+1] == 1) count++;
                if (i < board.length-1 && j > 0 && board[i+1][j-1] == 1) count++;
                if (i < board.length-1 && board[i+1][j] == 1) count++;
                if (i < board.length-1 && j < board[i].length-1 && board[i+1][j+1] == 1) count++;
                nei[i][j] = count;
            }
        }
        return nei;
    }
    
    public static void main(String[] args) {
    	GameOfLife_289 o = new GameOfLife_289();
    	int[][] board = {{0,1,0},
    	                 {0,0,1},
    	                 {1,1,1},
    	                 {0,0,0}};
    	o.gameOfLife(board);
    }
}