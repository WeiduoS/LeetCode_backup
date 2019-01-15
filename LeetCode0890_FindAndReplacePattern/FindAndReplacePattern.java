package LeetCode0890_FindAndReplacePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAndReplacePattern {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String word : words) {
            if(valid(word.toCharArray(), pattern.toCharArray())) {
                list.add(word);
            }
        }
        return list;
    }
    
    private boolean valid(char[] target, char[] source) {
        /*
        if(target.length != source.length) return false;
        Map<Character, Character> tmap = new HashMap<>();
        Map<Character, Character> smap = new HashMap<>();
        System.out.println("target: " + new String(target) + ", source: " + new String(source));
        for(int i = 0; i < target.length; i++) {
            char t = target[i], s = source[i];
            if(!smap.containsKey(s) && !tmap.containsKey(t)) {
                smap.put(s, t);
                tmap.put(t, s);
            }else{
                if(!smap.containsKey(s) || !tmap.containsKey(t)) return false;
                if(smap.get(s) != t || tmap.get(t) != s) return false;
            }
        }
        return true;*/
        if(target.length != source.length) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < target.length; i++) {
            if(!map.containsKey(source[i])) {
                map.put(source[i], target[i]);
            }
            if(map.get(source[i]) != target[i]) return false;
        }
        Set<Character> set = new HashSet<>();
        for(Map.Entry<Character, Character> e : map.entrySet()) {
            if(set.contains(e.getValue())) return false;
            set.add(e.getValue());
        }
        return true;
    }
}
