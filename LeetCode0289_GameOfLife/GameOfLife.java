package LeetCode0289_GameOfLife;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        if(board == null || n == 0 || m == 0) return;
        // case 1: under-population change to 2
        // case 2: next generation no change
        // case 3: over-population change to 2
        // case 4: reproduction change to 3
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int neighbor = findNeighbors(board, i , j);
                if(board[i][j] == 1) {
                    if(neighbor < 2 || neighbor > 3) {
                        board[i][j] = 2;
                    }
                }
                if(board[i][j] == 0) {
                    if(neighbor == 3) board[i][j] = 3;
                }
            }
        }
        // System.out.println(Arrays.deepToString(board));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0 , -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    private int findNeighbors(int[][] board, int row, int col) {
        int n = board.length;
        int m = board[0].length;
        int neighbor = 0;
        
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if(r < 0 || c < 0 || r > n - 1 || c > m - 1) continue;
            if(board[r][c] == 1 || board[r][c] == 2) neighbor++;
        }
        return neighbor;
    }	
}