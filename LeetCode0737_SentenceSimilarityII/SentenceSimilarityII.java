package LeetCode0737_SentenceSimilarityII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SentenceSimilarityII {
	/*
    class UnionFindSet {
        int[] parents;
        int[] ranks;
        UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            for(int i = 0; i < parents.length; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if(root_x == root_y) return;
            
            if(ranks[root_x] == ranks[root_y]) {
                parents[root_y] = root_x;
                ranks[root_x]++;
            }else{
                int smaller = ranks[root_x] < ranks[root_y] ? root_x : root_y;
                int greater = ranks[root_x] < ranks[root_y] ? root_y : root_x;
                parents[smaller] = greater;
            }
        }
        
        int find(int x) {
            if(parents[x] != x) parents[x] = find(parents[parents[x]]);
            return parents[x];
        }
    }
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        UnionFindSet uf = new UnionFindSet(2001);
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String[] pair : pairs) {
            if(!map.containsKey(pair[0])) {
                map.put(pair[0], index++);
            }
            if(!map.containsKey(pair[1])) {
                map.put(pair[1], index++);
            }
            uf.union(map.get(pair[0]), map.get(pair[1]));
        }
        for(int i = 0; i < words1.length; i++) {
            String t1 = words1[i], t2 = words2[i];
            if(t1.equals(t2)) continue;
            if(!map.containsKey(t1) || !map.containsKey(t2)) return false;
            if(uf.find(map.get(t1)) != uf.find(map.get(t2))) return false;
        }
        return true;
    }*/
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        Map<String, List<String>> map = new HashMap<>();
        for(String[] p : pairs) {
            map.computeIfAbsent(p[0], x -> new ArrayList<>());
            map.computeIfAbsent(p[1], x -> new ArrayList<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        
        for(int i = 0; i < words1.length; i++) {
            String t1 = words1[i], t2 = words2[i];
            Stack<String> stack = new Stack<>();
            stack.push(t1);
            Set<String> set = new HashSet<>();
            search: {
               while(!stack.isEmpty()) {
                    String temp = stack.pop();
                    if(temp.equals(t2)) break search;
                    if(map.containsKey(temp)) {
                        for(String neig : map.get(temp)) {
                            if(set.contains(neig)) continue;
                            set.add(neig);
                            stack.push(neig);
                        }
                    }
                } 
                return false;
            }
        }
        return true;
    }
}
