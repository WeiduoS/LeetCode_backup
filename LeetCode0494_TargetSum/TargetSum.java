package LeetCode0494_TargetSum;

public class TargetSum {
	// solution 1: DFS
    /*
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0, 0);
    }
    private int dfs(int[] nums, int S, int sum, int index) {
        if(index == nums.length) {
            return sum == S ? 1 : 0;
        }else{
            return dfs(nums, S, sum + nums[index], index + 1) + dfs(nums, S, sum - nums[index], index + 1);
        }       
    }*/
    // solution 2: DP(push)
    // dp[i][j + nums[i] + sum] += dp[i - 1][j + sum];
    // dp[i][j - nums[i] + sum] += dp[i - 1][j + sum];
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(Integer num : nums) {
            sum += num;
        }
        if(sum < S) return 0;
        int[][] dp = new int[nums.length][2*sum + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;
        //System.out.println("result 0: " + Arrays.toString(dp[0]));
        for(int i = 1; i < nums.length; i++) {
            for(int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + sum] > 0) {
                    dp[i][j + nums[i] + sum] += dp[i - 1][j + sum];
                    dp[i][j - nums[i] + sum] += dp[i - 1][j + sum];
                }
            }
            System.out.println("result " + i + ": " + Arrays.toString(dp[i]));
        }
        return dp[nums.length - 1][sum + S];
    }*/
    //solution 3: DP(pull)
    // dp[i][j + sum] = dp[i - 1][sum + j - nums[i]] + dp[i - 1][sum + j + nums[i]]
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(Integer num : nums) {
            sum += num;
        }
        if(sum < S) return 0;
        int[][] dp = new int[nums.length][2*sum + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;
        //System.out.println("result 0: " + Arrays.toString(dp[0]));
        for(int i = 1; i < nums.length; i++) {
            for(int j = -sum; j <= sum; j++) {
                //System.out.println("j: " + j);
                if(sum + j - nums[i] >= 0) {
                    dp[i][j + sum] += dp[i - 1][sum + j - nums[i]];
                }
                if(j + nums[i] <= sum) {
                    dp[i][j + sum] += dp[i - 1][sum + j + nums[i]];
                }
            }
            //System.out.println("result " + i + ": " + Arrays.toString(dp[i]));
        }
        return dp[nums.length - 1][sum + S];
    }*/
    
    // solution 4： optimize + pull
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(Integer num : nums) sum += num;
        if(sum < S) return 0;
        int[] dp = new int[2*sum + 1];
        dp[sum + nums[0]] += 1;
        dp[sum - nums[0]] += 1;
        for(int i = 1; i < nums.length; i++) {
            int[] next = new int[2*sum + 1];
            for(int j = -sum; j <= sum; j++) {
                if(dp[j + sum] > 0) {
                    next[j + nums[i] + sum] += dp[j + sum];
                    next[j - nums[i] + sum] += dp[j + sum];
                }
            }
            //System.out.println(Arrays.toString(next));
            dp = next;
        }
        return dp[sum + S];
    }*/
    
    // solution 5： optimize + push
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(Integer num : nums) sum += num;
        if(sum < S) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum + nums[0]] += 1;
        dp[sum - nums[0]] += 1;
        for(int i = 1; i < nums.length; i++) {
            int[] next = new int[2*sum + 1];
            for(int j = -sum; j <= sum; j++) {
                if(j + nums[i] <= sum ){
                    next[j + sum] += dp[j + nums[i] + sum];
                }
                if(j - nums[i] + sum >= 0) {
                    next[j + sum] += dp[j - nums[i] + sum]; 
                }
            }
            dp = next;
        }
        return dp[S + sum];
    }*/
    // solution 6: subset
    /*                    sum(P) - sum(N) = target
     *  sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                    2 * sum(P) = target + sum(nums)
     *
     * example:
     *  sum(1,3,5) - sum(2,4) + sum(1,3,5) + sum(2,4) = target + sum(1,3,5) + sum(2,4)
     *
     *                         2sum(1,3,5) = target + sum(1,3,5) + sum(2,4)
     *
     *                             2sum(P) = target + sum(nums)
     *
     *                              sum(P) = (target + sum(nums)) / 2
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(Integer num : nums) sum += num;
        if(S > sum || (S + sum) % 2 > 0) return 0;
        int target = (sum + S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}