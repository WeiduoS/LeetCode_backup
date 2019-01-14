package LeetCode0877_StoneGame;

public class StoneGame {
	/*
    public boolean stoneGame(int[] piles) {
        return score(piles, 0, piles.length - 1) > 0;
    }
    private int score(int[] piles, int l, int r) {
        if(l == r) return piles[l];
        return Math.max(piles[l] - score(piles, l + 1, r),
                       piles[r] - score(piles, l, r - 1));
    }*/
    /*
    Integer[][] memo;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new Integer[n][n];
        return score(piles, 0, n - 1) > 0;
    }
    
    private int score(int[] piles, int l, int r) {
        if(l == r) return piles[l];
        if(memo[l][r] != null) return memo[l][r];
        memo[l][r] = Math.max(piles[l] - score(piles, l + 1, r),
                       piles[r] - score(piles, l, r - 1));
        return memo[l][r];
        
    }*/
    /*
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = piles[i];
        for(int l = 2; l <= n; l++) {
            for(int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }*/
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for(int l = 2; l <= n; l++) {
            for(int i = 0; i < n - l + 1; i++) {
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[i + l - 1] - dp[i]);
            }
        }
        return dp[0] > 0;
    }
}
