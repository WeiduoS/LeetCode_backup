package LeetCode0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	// solution 1: HashMap + Sort
    public List<List<String>> groupAnagramsI (String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
    
    // solution 2: HashMap + Counting sort
    public List<List<String>> groupAnagramsII (String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        
        for(String str : strs) {
            System.out.println(str);
            int[] count = new int[26];
            for(char c : str.toCharArray()) count[c - 'a']++;
            
            String s = "";
            for(int i = 0; i < count.length; i++) {
                if(count[i] != 0){
                    s = s + count[i] + String.valueOf((char)(i + 'a'));
                }
            }
            if(map.containsKey(s)) {
                map.get(s).add(str);
            }else{
                map.put(s, new ArrayList());
                map.get(s).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}