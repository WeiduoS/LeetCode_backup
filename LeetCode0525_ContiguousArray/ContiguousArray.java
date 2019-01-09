package LeetCode0525_ContiguousArray;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // initization
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return res;
    }
}
