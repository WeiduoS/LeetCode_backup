package LeetCode0329_LongestIncreasingPathInAMatrix;

public class LongestIncreasingPathInAMatrix {
	public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if(matrix == null || n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        return res;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] != -0) return dp[i][j];
        dp[i][j] = 1;
        int res = 0;
        for(int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if(row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1 || matrix[row][col] <= matrix[i][j]) continue;
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, dp, row, col));
        }
        return dp[i][j];
    }	
}