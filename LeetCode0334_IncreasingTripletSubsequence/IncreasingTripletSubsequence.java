package LeetCode0334_IncreasingTripletSubsequence;

public class IncreasingTripletSubsequence {
	/*
    // solution 1: brute force
    public boolean increasingTriplet(int[] nums) {
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i; j < nums.length - 1; j++) {
                while(j < nums.length - 1 && nums[j] <= nums[i]) j++;
                for(int k = j; k < nums.length; k++) {
                    while(k < nums.length && nums[k] <= nums[j]) k++;
                    if(k < nums.length) return true;
                }
            }
        }
        
        return false;
    }*/
    /*
    // solution 2: dynamic programming
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] >= 3) return true;
                }
            }
        }
        return false;
    }*/
    
    // solution 3: O(n) O(1)
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) {
                first = nums[i];
            }else if(nums[i] <= second){
                second = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }	
}