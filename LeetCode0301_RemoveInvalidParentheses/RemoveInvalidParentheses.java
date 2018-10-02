package LeetCode0301_RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveInvalidParentheses{
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        
        Set<String> set = new HashSet<>();
        // the number of '(' and ')' need to remove
        int l = 0;
        int r = 0;
        int[] count = new int[2];
        for(char c : s.toCharArray()) {
            if(c == '(') l++;
            if(l == 0 && c ==')') {
                r++;
            }else if (c == ')'){
                l--;
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {map.compute(c, (key , val) -> val == null ? 1 : val + 1);}
        if(l > 0) map.put('(', map.get('(') - l);
        if(r > 0) map.put(')', map.get(')') - r);
        //System.out.println("l: " + l + ", r: " + r);
        backtracking(s, count, 0, res, "", l + r, map, set);
        return res;
    }
    
    private void backtracking(String s, int[]count, int pos, List<String> res, String temp, int remover, Map<Character, Integer> map, Set<String> set) {
        if(temp.length() == s.length() - remover) {
            if(!set.contains(temp)) {
                set.add(temp);
                res.add(temp);
            }
            return;
        }
        for(int i = pos; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 0) continue;
            if(c == ')' && (map.get('(') >= map.get(')'))) {
                continue;
            }
            map.put(c, map.get(c) - 1);
            temp += c;
            //System.out.println("temp: " + temp + ", remover: " + remover);
            backtracking(s, count, i + 1, res, temp, remover, map, set);
            map.put(c, map.get(c) + 1);
            temp = temp.substring(0, temp.length() - 1);
            
        }
    }	
}