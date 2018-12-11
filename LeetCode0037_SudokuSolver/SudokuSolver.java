package LeetCode0037_SudokuSolver;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int row, int col) {
        while(row < 9 && col < 9) {
            if(board[row][col] == '.') break;
            if(col == 8) {
                col = 0;
                row++;
            }else{
                col++;
            }
        }
        
        if(row == 9) return true;
        
        int nextRow = row + col / 8, nextCol = (col + 1) % 9;
        for(int num = 1; num <= 9; num++) {
            if(isVaild(board, row, col, num)) {
                board[row][col] = (char)(num +'0');
                boolean result = helper(board, nextRow, nextCol);
                if(result) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean isVaild(char[][] board, int r, int c, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[r][i] - '0' == num) return false;
            if(board[i][c] - '0' == num) return false;
        }
        int row = (r / 3) * 3, col = (c / 3) * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[row + i][col + j] - '0' == num) return false;
            }
        }
        return true;
    }
}
