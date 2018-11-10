package LeetCode0727_MinimumWindowSubsequence;

import java.util.Arrays;

public class MinimumWindowSubsequence {
	public String minWindow(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for(int i = 0; i <= S.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for(int i = 0; i <= S.length(); i++) {
            dp[i][0] = i;
        }
        
        int start = -1, minLen = Integer.MAX_VALUE;
        for(int i = 1; i <= S.length(); i++) {
            for(int j = 1; j <= T.length(); j++) {
                if(S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            
            if(dp[i][T.length()] != -1) {
                    if(i - dp[i][T.length()] < minLen) {
                        minLen = i - dp[i][T.length()];
                        start = dp[i][T.length()];
                    }
            }
        }
        
        return start == -1 ? "": S.substring(start, start + minLen);
    }
}
