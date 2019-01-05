package LeetCode0659_SplitArrayIntoConsecutiveSubsequences;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
	public boolean isPossible(int[] nums) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for(int num : nums) {
            start.put(num, start.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums) {
            if(start.get(num) == 0) continue;
            // append to an exsiting consecutive sequence
            if(end.getOrDefault(num, 0) > 0) {
                end.put(num, end.get(num) - 1);
                end.put(num + 1, end.getOrDefault(num + 1, 0) + 1);
            }else if(start.getOrDefault(num + 1, 0) > 0 && start.getOrDefault(num + 2, 0) > 0) {
                // create a new consecutive sequence of 3 elements
                start.put(num + 1, start.getOrDefault(num + 1, 0) - 1);
                start.put(num + 2, start.getOrDefault(num + 2, 0) - 1);
                end.put(num + 3, end.getOrDefault(num + 3, 0) + 1);
            }else{
                return false;
            }
            start.put(num , start.get(num) - 1);
        }
        return true;
    }
}
