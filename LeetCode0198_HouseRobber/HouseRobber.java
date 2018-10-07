package LeetCode0198_HouseRobber;

public class HouseRobber {
	public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return nums[0] >= nums[1] ? nums[0] : nums[1];
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max((nums[i - 1] + dp[i - 2]), (nums[i - 1] + dp[i - 3]));
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n - 1] >= dp[n] ? dp[n - 1] : dp[n];
    }	
}