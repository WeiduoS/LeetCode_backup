package LeetCode0115_DistinctSubsequences;

import java.util.Arrays;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                //System.out.println("i: " + i + ", j: " + j);
                //System.out.println("i: " + t.charAt(i - 1) + ", j: " + s.charAt(j - 1));
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                     dp[i][j] = dp[i][j - 1];
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }
}
