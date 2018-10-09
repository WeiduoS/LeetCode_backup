package LeetCode0312_BurstBalloons;

public class BurstBalloons {
	public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        for(int len = 1; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for(int k = i; k <= j; k++) {
                    int leftValue = 1;
                    int rightValue = 1;
                    if(i != 0) leftValue = nums[i - 1];
                    if(j != n - 1) rightValue = nums[j + 1];
                    int leftSum = 0;
                    int rightSum = 0;
                    if(i != k) leftSum = dp[i][k - 1];
                    if(j != k) rightSum = dp[k + 1][j];
                    dp[i][j] = Math.max(leftValue * nums[k]* rightValue + leftSum + rightSum, dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}