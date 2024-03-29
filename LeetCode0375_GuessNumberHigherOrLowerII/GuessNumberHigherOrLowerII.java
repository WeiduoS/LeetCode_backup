package LeetCode0375_GuessNumberHigherOrLowerII;

public class GuessNumberHigherOrLowerII {
	/*
    public int getMoneyAmount(int n) {
       return helper(1, n);
    }
    
    private int helper(int l, int r) {
        if(l >= r) return 0;
        int cost = Integer.MAX_VALUE;
        for(int i = (l + r) / 2; i <= r; i++) {
            int res = i + Math.max(helper(l, i - 1), helper(i + 1, r));
            cost = Math.min(res, cost);
        }
        return cost;
    }*/
    
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 2; i <= n; i++) {
            for(int j = i - 1; j > 0; j--) {
                int global_min = Integer.MAX_VALUE;
                for(int k = j + 1; k < i; k++) {
                    int local_max = k + Math.max(dp[j][k - 1], dp[k + 1][i]);
                    global_min = Math.min(global_min, local_max);
                }
                dp[j][i] = j + 1 == i ? j : global_min;
            }
        }
        return dp[1][n];
    }
}
