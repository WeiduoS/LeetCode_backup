package LeetCode0594_LongestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	Map<Integer, Integer> map = new HashMap<>();
    public int findLHS(int[] nums) {
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(map.containsKey(entry.getKey() - 1)) {
                res = Math.max(entry.getValue() + map.get(entry.getKey() - 1), res);
            }
            if(map.containsKey(entry.getKey() + 1)) {
                res = Math.max(entry.getValue() + map.get(entry.getKey() + 1), res);
            }
        }
        return res;
    }
}
