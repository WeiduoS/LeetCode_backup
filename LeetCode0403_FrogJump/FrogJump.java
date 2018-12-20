package LeetCode0403_FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump {
	public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(1);
        
        for(int i = 0; i < n; i++) {
            for(int step : map.get(stones[i])) {
                int reach = step + stones[i];
                if(reach == stones[n - 1]) return true;
                //System.out.println("reach: " + reach);
                if(!map.containsKey(reach)) continue;
                if(step > 0) map.get(reach).add(step - 1);
                map.get(reach).add(step);
                map.get(reach).add(step + 1);
            }
        }
        return false;
    }
}
