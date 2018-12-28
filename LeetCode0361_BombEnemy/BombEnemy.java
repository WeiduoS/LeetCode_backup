package LeetCode0361_BombEnemy;

public class BombEnemy {
	/*
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int row = 0;
        int[] col = new int[grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'W' ) continue;
                if(j == 0 || grid[i][j - 1] == 'W') {
                    row = rowEnemies(grid, i, j);
                }
                if(i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = colEnemies(grid, i, j);
                }
                //System.out.println("row: " + row + ", col: " + Arrays.toString(col));
                if(grid[i][j] == '0') res = Math.max(res, row + col[j]);
            }
        }
        return res;
    }
    
    private int rowEnemies(char[][] grid, int row, int col) {
        int res = 0;
        for(int i = col; i < grid[0].length; i++) {
            if(grid[row][i] == 'W') break;
            if(grid[row][i] == 'E') res++;
        }
        return res;
    }
    private int colEnemies(char[][] grid, int row, int col) {
        int res = 0;
        for(int i = row; i < grid.length; i++) {
            if(grid[i][col] == 'W') break;
            if(grid[i][col] == 'E') res++;
        }
        return res;
    }*/
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int t = (j == 0 || grid[i][j] == 'W') ? 0 : left[i][j - 1];
                left[i][j] = grid[i][j] == 'E' ? t + 1 : t;
            }
            for(int j = n - 1; j >= 0; j--) {
                int t = (j == n - 1 || grid[i][j] == 'W') ? 0 : right[i][j + 1];
                right[i][j] = grid[i][j] == 'E' ? t + 1 : t;
            }
        }
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                int t = (i == 0 || grid[i][j] == 'W') ? 0 : up[i - 1][j];
                up[i][j] = grid[i][j] == 'E' ? t + 1 : t;
            }
            for(int i = m - 1; i >= 0; i--) {
                int t = (i == m - 1 || grid[i][j] == 'W') ? 0 : down[i + 1][j];
                down[i][j] = grid[i][j] == 'E' ? t + 1 : t;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
