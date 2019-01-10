package LeetCode0767_ReorganizeString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
	public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a, b) ->(b.getValue() - a.getValue()));
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            if(e.getValue() > (S.length() + 1) / 2) return "";
            q.offer(e);
        }
        String res = "";
        while(q.size() >= 2) {
            Map.Entry<Character, Integer> e1 = q.poll();
            Map.Entry<Character, Integer> e2 = q.poll();
            res += e1.getKey();
            res += e2.getKey();
            int value1 = e1.getValue();
            if(value1 > 1) {
                e1.setValue(value1 - 1);
                q.offer(e1);
            }
            int value2 = e2.getValue();
            if(value2 > 1) {
                e2.setValue(value2 - 1);
                q.offer(e2);
            }
        }
        if(!q.isEmpty()) res += q.poll().getKey();
        return res;
    }
}
