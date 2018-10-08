package LeetCode0300_LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    // solution 1: binary Search
    /*
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] tailMemo = new int[nums.length];
        tailMemo[0] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            System.out.println(Arrays.toString(tailMemo));
            if(nums[i] < tailMemo[0]) {
                tailMemo[0] = nums[i];
            }else if(nums[i] > tailMemo[len - 1]) {
                tailMemo[len++] = nums[i];
            }else {
                tailMemo[ceilingIndex(tailMemo, -1, len - 1, nums[i])] = nums[i];
            }
        }
        return len;
    }
    
    private int ceilingIndex(int[] tailMemo, int l, int r, int key) {
        while(l + 1 < r) {
            int m = l +(r - l) / 2;
            if(tailMemo[m] >= key) {
                r = m;
            }else{
                l = m;
            }
        }
        return r;
    }*/
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        int[] dp = new int[n];
        int maxLen = 1;
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }	
}