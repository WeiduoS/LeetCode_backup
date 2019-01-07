package LeetCode0688_KnightProbabilityInChessboard;

public class KnightProbabilityInChessboard {
	public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double[][] dp0 = new double[N][N];
        //for(double[] row : dp0) Arrays.fill(row, 1);
        dp0[r][c] = 1.0;
        int count = 0;
        while(count++ < K) {
            double[][] dp1 = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x < 0 || y < 0 || x >= N || y >= N) continue;
                        dp1[i][j] += dp0[x][y];
                    }
                }
            }
            dp0 = dp1;
        }
        //System.out.println(dp0[r][c] + ", Math.pow(8, K): " + Math.pow(8, K));
        double res = 0;
        for(double[] row : dp0) {
            for(double num : row) res += num;
        }
        return res / Math.pow(8, K);
    }
}
