package LeetCode0416_PartitionEqualSubsetSum;

public class PartitionEqualSubsetSum {
	/*
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        for(int i = 0; i <= nums.length; i++) dp[i][0] = true;
        
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= sum / 2; j++) {
                if(j >= nums[i - 1]) {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        
        return dp[nums.length][sum / 2];
    }*/
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        /** dp[j] = dp[j] || dp[j - nums[i]] (nums[i] <= j <= target)
            有了状态转移方程，那么我们就可以写出代码了，这里需要特别注意的是，第二个for循环一定要从target遍历到nums[i]，而不能反过来，想想为什么呢？
            因为如果我们从nums[i]遍历到target的话，假如nums[i]=1的话，那么[1, target]中所有的dp值都是true，因为dp[0]是true，dp[1]会或上
            dp[0]，为true，dp[2]会或上dp[1]，为true，依此类推，完全使我们的dp数组失效了 */
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum / 2; j > 0; j--) {
                // 
                if(j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        
        return dp[sum / 2];
    }
}
