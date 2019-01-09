package LeetCode0723_CandyCrush;

public class CandyCrush {
	public int[][] candyCrush(int[][] board) {
        boolean todo = false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length - 2; j++) {
                int t = Math.abs(board[i][j]);
                if(t != 0 && Math.abs(board[i][j + 1]) == t && Math.abs(board[i][j + 2]) == t) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -t;
                    todo = true;
                }
            }
        }
        
        for(int i = 0; i < board.length - 2; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int t = Math.abs(board[i][j]);
                if(t != 0 && Math.abs(board[i + 1][j]) == t && Math.abs(board[i + 2][j]) == t) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -t;
                    todo = true;
                }
            }
        }
        
        for(int j = 0; j < board[0].length; j++) {
            int index = board.length - 1;
            for(int i = board.length - 1; i >= 0; i--){
                if(board[i][j] > 0) {
                    board[index--][j] = board[i][j];
                }
            }
            while(index >= 0) board[index--][j] = 0;
        }
        
        return todo ? candyCrush(board) : board;
    }
}
