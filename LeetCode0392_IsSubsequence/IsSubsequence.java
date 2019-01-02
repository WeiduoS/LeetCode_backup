package LeetCode0392_IsSubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {
	/*
    public boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0;
        while(si < s.length() && ti < t.length()) {
            if(s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            }else{
                ti++;
            }
        }
        return si == s.length();
    }*/
    
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int index = 0;
        for(char c : t.toCharArray()) {
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(index++);
        }
        
        int prev = -1;
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            int j = Collections.binarySearch(list, prev);
            if(j < 0) j = -j - 1;
            if(j == list.size()) return false;
            prev = list.get(j) + 1;
        }
        
        return true;
    }
}
