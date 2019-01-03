package LeetCode0465_OptimalAccountBalancing;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
	public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] tran : transactions) {
            map.put(tran[0], map.getOrDefault(tran[0], 0) - tran[2]);
            map.put(tran[1], map.getOrDefault(tran[1], 0) + tran[2]);
        }
        int[] debt = new int[map.size()];
        int index = 0;
        for(int amount : map.values()) {
            debt[index++] = amount;
        }
        return helper(0, debt);
    }
    
    private int helper(int cur, int[] debt) {
        while(cur < debt.length && debt[cur] == 0) cur++;
        
        if(cur == debt.length) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = cur + 1; i < debt.length; i++) {
            if(debt[i] * debt[cur] < 0) {
                debt[i] += debt[cur];
                min = Math.min(min, helper(cur + 1, debt) + 1);
                debt[i] -= debt[cur];
            }
        }
        
        return min;
    }
}
