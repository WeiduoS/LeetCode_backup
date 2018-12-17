package LeetCode0960_DeleteColumnsToMakeSortedIII;

import java.util.Arrays;

public class DeleteColumnsToMakeSortedIII {
	public int minDeletionSize(String[] A) {
        int len = A[0].length();
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                int r = 0;
                for(; r < A.length; r++) {
                    if(A[r].charAt(j) > A[r].charAt(i)) break;
                }
                if(r == A.length) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.min(len - dp[i], ans);
        }
        return ans;
    }
}
