package LeetCode0325_MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
	/*
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] preSum = new int[nums.length + 1];
        
        for(int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < preSum.length; i++) {          
            if(map.containsKey(preSum[i])) {
                map.get(preSum[i]).add(i);
            }else{
                map.put(preSum[i], new ArrayList<Integer>());
                map.get(preSum[i]).add(i);
            }
        }
        
        int maxSub = 0;
        for(int i = 0; i < preSum.length; i++) {
            if(map.containsKey(preSum[i] + k)) {
                for(Integer j : map.get(preSum[i] + k)) {
                    maxSub = Math.max(maxSub, (j - i));
                }
            }
        }
        return maxSub;
    }*/
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, maxSub = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, i + 1));
            if(map.containsKey(sum - k)) {
                maxSub = Math.max(maxSub, i + 1 - map.get(sum - k));
            }
        }
        return maxSub;
    }	
}