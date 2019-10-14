package TicTacToe;

public class ValidBoard {
	public boolean validTicTacToe(String[] board) {
        int cX = count(board,'X');
        int cO = count(board,'O');
        int diff = cX - cO;
        if (diff < 0 || diff > 1) return false;
        if (winX(board) && winO(board)) return false;
        if (winX(board)) return cX == cO + 1;
        if (winO(board)) return cO == cX;
        return true;
    }
    
    private boolean winX(String[] board) {
        char token = 'X';
        boolean res = false;
        for (int i = 0; i < board.length; i++)
            res = res || checkRow(board, i, token);
        if (res) return res;
        for (int i = 0; i < board.length; i++)
            res = res || checkCol(board, i, token);
        if (res) return res;
        res = res || checkDia(board, 1, token);
        if (res) return res;
        res = res || checkDia(board, -1, token);
        return res;
    }
    
    private boolean winO(String[] board) {
        char token = 'O';
        boolean res = false;
        for (int i = 0; i < board.length; i++)
            res = res || checkRow(board, i, token);
        if (res) return res;
        for (int i = 0; i < board.length; i++)
            res = res || checkCol(board, i, token);
        if (res) return res;
        res = res || checkDia(board, 1, token);
        if (res) return res;
        res = res || checkDia(board, -1, token);
        return res;
    }
    
    private boolean checkRow(String[] board, int r, char token) {
        String s = board[r];
        int count = 0;
        for(char c: s.toCharArray())
            if (c == token) count++;
        return count == board.length;
    }
    
    private boolean checkCol(String[] board, int c, char token) {
        int count = 0;
        for (String s: board){
            if (s.charAt(c) == token)
                count++;
        }
        return count == board.length;
    }
    
    private boolean checkDia(String[] board, int x, char token) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (x == 1) {
                if (board[i].charAt(i) == token) count++;
            }
            else {
                if (board[i].charAt(board.length - (i+1)) == token) count++;
            }
        }
        return count == board.length;
    }
    
    private int count(String[] board, char ch) {
        int count = 0;
        for(String s: board) {
            for(char c: s.toCharArray()) 
                if (c == ch) count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		String[] board = {"O  ","   ","   "};
		ValidBoard o = new ValidBoard();
		System.out.println(o.validTicTacToe(board));
	}

}
