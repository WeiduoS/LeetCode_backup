package LeetCode0055_JumpGame;

public class JumpGame {
	// own solution
    /*
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0 && dp[j] == true; j--) {
                if(nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }*/
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] + i >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }
}