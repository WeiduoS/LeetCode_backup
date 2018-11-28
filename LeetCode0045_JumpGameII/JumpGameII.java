package LeetCode0045_JumpGameII;

public class JumpGameII {
	// solution 1: dynamic programming which is own really slow solution T _ T
    /*
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length + 1);
        dp[0] = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int j = i + 1, steps = nums[i], totalsteps = dp[i] + 1;
            while(j < nums.length && steps > 0) {
                dp[j] = Math.min(totalsteps, dp[j]);
                j++;
                steps--;
            }
        }
        return dp[dp.length - 1];
    }*/
    
    
    public int jump(int[] nums) {
        int reach = 0, last = 0, minSteps = 0;
        if(nums.length <= 1) return 0;
        for(int i = 0; i < nums.length; i++) {
            if(reach >= nums.length - 1) return minSteps + 1;
            if(i > last) {
                last = reach;
                minSteps++;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return -1;
    }
}
