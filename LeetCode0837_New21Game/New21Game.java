package LeetCode0837_New21Game;

public class New21Game {
	public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double wsum = 0;
        for(int i = K + W - 1; i >= K; i--) {
            dp[i] = (i <= N) ? 1 : 0;
            wsum += dp[i];
        }
        for(int i = K - 1; i >= 0; i--) {
            dp[i] = wsum / W;
            wsum = wsum + dp[i] - dp[i + W];
        }
        return dp[0];
    }
}
