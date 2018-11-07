package LeetCode0451_SortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	/*
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] chars = new List[s.length() + 1];
        for(char key : map.keySet()) {
            int freq = map.get(key);
            if(chars[freq] == null) chars[freq]  = new ArrayList<>();
            chars[freq].add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] != null) {
                for(char c : chars[i]) {
                    for(int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }*/
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for(int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        
        return sb.toString();
    }	
}