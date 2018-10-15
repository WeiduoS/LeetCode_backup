package LeetCode0016_3SumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                // do not update in this loop
                if(Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if(sum == target) {
                    return res;
                }else if(sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }	
}