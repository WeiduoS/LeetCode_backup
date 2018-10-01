package LeetCode0079_WordSearch;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if(board == null || (board.length == 0 && word != "")) return false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtracking(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
    private boolean backtracking(char[][] board, String word, int row, int col, int index) {
        if(row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1|| board[row][col] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        char temp = board[row][col];
        board[row][col] = '0';
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if(backtracking(board, word, r, c, index + 1)) return true;
        }
        board[row][col] = temp;
        return false;
    }
}