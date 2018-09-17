package LeetCode0076_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int distinctChar = t.length();
        int subStart = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0, j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j)) ) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) >= 0) distinctChar--;
            }
            while (distinctChar == 0) {
                if(j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    subStart = i;
                }
                if(map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if(map.get(s.charAt(i)) > 0) distinctChar++;
                }
                i++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(subStart,subStart+minLen);
    }	
}