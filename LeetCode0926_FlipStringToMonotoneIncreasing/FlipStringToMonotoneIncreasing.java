package LeetCode0926_FlipStringToMonotoneIncreasing;

public class FlipStringToMonotoneIncreasing {
	/*
    public int minFlipsMonoIncr(String S) {
        int n = S.length();
        int[] leftzero = new int[n], rightone = new int[n];
        leftzero[0] = (S.charAt(0) == '0') ? 0 : 1;
        rightone[n - 1] = (S.charAt(n - 1) == '1') ? 0 : 1;
        for(int i = 1; i < n; i++) {
            leftzero[i] = (S.charAt(i) == '1') ? leftzero[i - 1] + 1 : leftzero[i - 1];
            rightone[n - i - 1] = (S.charAt(n - i - 1) == '0') ? rightone[n - i] + 1 : rightone[n - i];
        }
        int res = n;
        for(int i = -1; i < n; i++) {
            int left = i == -1 ? 0 : leftzero[i];
            int right = i == n - 1 ? 0 : rightone[i + 1];
            res = Math.min(res, left + right);
        }
        return res;
    }*/
    public int minFlipsMonoIncr(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
            if(S.charAt(i - 1) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            }else{
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
