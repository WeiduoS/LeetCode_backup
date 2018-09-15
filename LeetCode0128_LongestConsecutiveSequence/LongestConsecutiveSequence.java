package LeetCode0128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	// solution 1: hashsetI
    /*
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) set.add(num);
        int maxConsec = 0;
        for(Integer num : set) {
            int tempLen = 0;
            while(set.contains(num)) {
                num += 1;
                tempLen++;
            }
            maxConsec = Math.max(maxConsec, tempLen);
        }
        return maxConsec;
    }*/
    // solution 2: optimaze hashset
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) set.add(num);
        int maxConsec = 0;
        for(Integer num : set) {
            int tempLen = 0;
            if(!set.contains(num - 1)) {
                while(set.contains(num)) {
                    num += 1;
                    tempLen++;
                }
                maxConsec = Math.max(maxConsec, tempLen);
            }
        }
        return maxConsec;
    }
    // solution 3: UnionFind + hashmap
    /*
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxConsec = 0;
        for(int num : nums) {
            if(map.containsKey(num)) continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int total = left + right + 1;
            maxConsec = Math.max(maxConsec, total);
            if(left > 0 && right > 0) map.put(num, 0);
            map.put(num - left, total);
            map.put(num + right, total);
        }
        return maxConsec;
    }*/	
}