package LeetCode0410_SplitArrayLargestSum;

public class SplitArrayLargestSum {
	// solution 1: dynamic programming
    public int splitArrayI(int[] nums, int m) {
        int[][] dp = new int[nums.length + 1][m + 1];
        int[] preSum = new int[nums.length + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        //System.out.println(Arrays.deepToString(dp));
        for(int i = 0; i < preSum.length - 1; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        //System.out.println(Arrays.toString(preSum));
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                for(int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], preSum[i] - preSum[k]));
                    //System.out.println(Arrays.deepToString(dp));
                }
            }
        }
        return dp[nums.length][m];
    }
    // solution 2: Binary Search
    public int splitArrayII(int[] nums, int m) {
        int l = 0;
        int r = 0;
        for(int i = 0; i < nums.length; i++) {
            r += nums[i];
            if(l < nums[i]) l = nums[i];
        }
        System.out.println("l: " + l + ", r: " + r);
        int ans = r;
        while(l < r) {
            int mid = l + (r - l) / 2;
            int count = 1;
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                if(sum + nums[i] > mid) {
                    count++;
                    sum = nums[i];
                }else{
                    sum += nums[i];
                }
            }
            
            if(count <= m) {
                ans = Math.min(ans, mid);
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;  
    }	
}