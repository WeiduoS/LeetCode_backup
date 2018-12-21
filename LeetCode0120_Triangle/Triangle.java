package LeetCode0120_Triangle;

import java.util.List;

public class Triangle {
	/*
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int cur = triangle.get(i).get(j);
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + cur;
                } else if(j == triangle.get(i - 1).size()) {
                    dp[i][j] = dp[i - 1][j - 1] + cur;
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + cur, dp[i - 1][j] + cur);
                }
            }
        }
        for(int num : dp[dp.length - 1]) res = Math.min(res, num);
        return res;
    }*/
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
