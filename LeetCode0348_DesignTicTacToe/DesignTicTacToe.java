package LeetCode0348_DesignTicTacToe;

public class DesignTicTacToe {
	/*
    int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        if(row > board.length - 1 || col > board.length - 1) return 0;
        if(board[row][col] != 0) return 0;
        board[row][col] = player == 1 ? 1 : 2;
        if(checkVerticalWin(col, player)) return player;
        if(checkHorizontalWin(row, player)) return player;
        if(checkDiagonalWin(row, col, player)) return player;
        return 0;
    }
    
    private boolean checkVerticalWin(int col, int player) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] != player) return false;
        }
        return true;
    }
    
    private boolean checkHorizontalWin(int row, int player) {
        for(int i = 0; i < board[0].length; i++) {
            if(board[row][i] != player) return false;
        }
        return true;
    }
    
    private boolean checkDiagonalWin(int row, int col, int player) {
        
        if(row != col && row + col != board.length - 1) return false;
        boolean topLeftToBottomRight = true;
        boolean topRightToBottomLeft = true;
        
        for(int i = 0; i < board.length; i++) {
            if(board[i][i] != player) topLeftToBottomRight = false;
        }
        for(int i = 0; i < board.length; i++) {
            if(board[i][board.length - 1 - i] != player) topRightToBottomLeft = false;
        }
        return topRightToBottomLeft || topLeftToBottomRight;
    }*/
    
    int[] rows;
    int[] cols;
    int topLeftToBottomRight;
    int topRightToBottomLeft;
    /** Initialize your data structure here. 
     * @return */
    public void TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        topLeftToBottomRight = 0;
        topRightToBottomLeft = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += player == 1 ? 1 : -1;
        cols[col] += player == 1 ? 1 : -1;
        if(row == col) topLeftToBottomRight += player == 1 ? 1 : -1;
        if(row + col == rows.length - 1) topRightToBottomLeft += player == 1 ? 1 : -1;
        
        return (Math.abs(rows[row]) == rows.length || Math.abs(cols[col]) == cols.length|| Math.abs(topLeftToBottomRight) == rows.length || Math.abs(topRightToBottomLeft) == rows.length ) ? player : 0;
        
    }	
}