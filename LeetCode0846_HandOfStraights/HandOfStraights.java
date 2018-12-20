package LeetCode0846_HandOfStraights;

import java.util.TreeMap;

public class HandOfStraights {
	public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        
        for(int num : hand) {
            if(!count.containsKey(num)) count.put(num, 1);
            else count.replace(num, count.get(num) + 1);
        }
        
        while(!count.isEmpty()) {
            int first = count.firstKey();
            for(int i = first; i < first + W; i++) {
                if(!count.containsKey(i)) return false;
                if(count.get(i) == 1) count.remove(i);
                else count.replace(i, count.get(i) - 1);
            }
        }
        
        return true;
    }
}
