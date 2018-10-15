package LeetCode0560_SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	/*
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] preSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        //System.out.println(Arrays.toString(preSum));
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= nums.length; j++) {
                if(preSum[j] - preSum[i] == k) res++;
            }
        }
        return res;
    }*/
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }	
}