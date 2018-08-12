package leetCode0288_UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {
	Map<String, Set<String>> map = new HashMap<>();
    public void ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
            String temp = abbr(s);
            if(!map.containsKey(temp)) {
                map.put(temp, new HashSet<String>()); 
            }
            map.get(temp).add(s);
        }
    }
    
    public boolean isUnique(String word) {
        String temp = abbr(word);
        if(!map.containsKey(temp)) return true;
        if(map.containsKey(temp)) {
            if(map.get(temp).size() == 1 && map.get(temp).contains(word)) {
                return true;
            }
        }
        return false;
    }
    
    private static String abbr(String s) {
        if(s.length() <= 2) return s;
        String res = "";
        res = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
        return res;
    }
}