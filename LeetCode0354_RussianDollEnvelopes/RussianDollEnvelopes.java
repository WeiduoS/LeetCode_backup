package LeetCode0354_RussianDollEnvelopes;

import java.util.Arrays;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
        int res = 0;
        //System.out.println(Arrays.deepToString(envelopes));
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // System.out.println(Arrays.toString(dp));
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
