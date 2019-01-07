package LeetCode0259_3SumSmaller;

import java.util.Arrays;

public class TreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += search(nums, i + 1, target - nums[i]);
        }
        return res;
    }
    
    private int search(int[] nums, int pos, int target) {
        int l = pos, r = nums.length - 1;
        int res = 0;
        while(l < r) {
            if(nums[l] + nums[r] < target) {
                //System.out.println("nums[l]: " + nums[l] + ", nums[r]: " + nums[r] + ", target: " + target);
                res += r - l;
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
