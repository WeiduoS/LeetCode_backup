package LeetCode0220_ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	// solution 1: BST tree
    public boolean containsNearbyAlmostDuplicateI(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Integer succ = set.ceiling(nums[i]);
            Integer pred = set.floor(nums[i]);
            // the follow statement cannot pass [-2147483648,-2147483647] 3 3
            //if((succ != null && succ <= nums[i] + t) || (pred != null && pred >= nums[i] - t)) return true;
            if((succ != null && succ <= nums[i] + t) || (pred != null && pred + t >= nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k) set.remove(nums[i - k]);
        }
        
        return false;
    }
    
    // soltuion 2: bucket sort
    public boolean containsNearbyAlmostDuplicateII(int[] nums, int k, int t) {
        if(t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            long index = (nums[i] < 0)? (nums[i] + 1) / (t + 1) - 1 : nums[i] / (t + 1); 
            if(map.containsKey(index)) return true;
            if(map.containsKey(index - 1) && Math.abs(nums[i] - map.get(index - 1)) <= t) return true;
            if(map.containsKey(index + 1) && Math.abs(map.get(index + 1) - nums[i]) <= t) return true;
            
            map.put(index, (long)nums[i]);
            if(i >= k) {
                long lastIndex =  (nums[i - k] < 0)? (nums[i - k] + 1) / (t + 1) - 1 : nums[i - k] / (t + 1);
                map.remove(lastIndex);
            }
        }
        return false;
    }
}