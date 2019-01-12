package LeetCode0807_MaxIncreaseToKeepCitySkyline;

public class MaxIncreaseToKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[] rows = new int[m], cols = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res += Math.min(rows[i] - grid[i][j], cols[j] - grid[i][j]);
            }
        }
        return res;
    }
}
