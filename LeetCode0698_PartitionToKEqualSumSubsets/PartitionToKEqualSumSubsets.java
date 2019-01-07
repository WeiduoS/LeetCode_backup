package LeetCode0698_PartitionToKEqualSumSubsets;

public class PartitionToKEqualSumSubsets {
	boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % k != 0) return false;
        visited = new boolean[nums.length];
        boolean res = helper(nums, 0, 0, sum / k, 0, k);
        //System.out.println("res: " + res);
        return res;
    }
    
    private boolean helper(int[] nums, int sum, int pos, int target, int buckets, int k) {
        if(buckets == k) return true;
        if(sum == target) {
            return helper(nums, 0, 0, target, buckets + 1, k);
        }

        for(int i = pos; i < nums.length; i++) {
            if(visited[i] == true) continue;
            if(sum + nums[i] <= target){
                visited[i] = true;
                if(helper(nums, sum + nums[i], i + 1, target, buckets, k)) return true;;
                visited[i] = false;
            }
        }
        return false;
    }
}
