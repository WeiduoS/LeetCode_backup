package LeetCode0677_MapSumPairs;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
	/*
    Map<String, Integer> map;
    Map<String, Integer> score;
    // Initialize your data structure here. 
    public MapSum() {
        map = new HashMap<>();
        score = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int increment = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for(char c : key.toCharArray()) {
            prefix += c;
            score.put(prefix, score.getOrDefault(prefix, 0) + increment);
        }
        
    }
    
    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }*/
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int score;
    }
    Map<String, Integer> map;
    TrieNode root;
    
    public MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int increment = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += increment;
        for(char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += increment;
        }
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if(cur == null) return 0;
        }
        return cur.score;
    }
}