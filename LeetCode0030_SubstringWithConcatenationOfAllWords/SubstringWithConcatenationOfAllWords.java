package LeetCode0030_SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	/*
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s == null || words.length == 0) return list;
        Map<String, Integer> counts = new HashMap<>();
        for(String str : words) {
            counts.put(str, counts.getOrDefault(str, 0) + 1);
        }
        int n = s.length(), len = words[0].length(), num = words.length;
        for(int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int j = 0;
            for(; j < num; j++) {
                String temp = s.substring(i + j * len, i + (j + 1) * len);
                if(counts.containsKey(temp)) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    if(map.get(temp) > counts.get(temp)) break;
                }else{
                    break;
                }
            }
            if(j == num) {
                list.add(i);
            }
        }
        return list;
    }*/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;
        
        Map<String, Integer> cnt = new HashMap<>();
        for(String str : words) {
            cnt.put(str, cnt.getOrDefault(str, 0) + 1);
        }
        
        int wl = words[0].length();
        for(int i = 0; i < wl; i++) {
            int l = i, r = i;
            Map<String, Integer> window = new HashMap<>();
            int windowCnt = 0;
            while(r + wl <= s.length()) {
                String w = s.substring(r, r + wl);
                r += wl;
                window.put(w, window.getOrDefault(w, 0) + 1);
                windowCnt++;
                
                while(window.getOrDefault(w, 0) > cnt.getOrDefault(w, 0)) {
                    String leadingWord = s.substring(l, l + wl);
                    window.put(leadingWord, window.get(leadingWord) - 1);
                    l += wl;
                    windowCnt--;
                }
                if (windowCnt == words.length) res.add(l);
            }
        }
        
        return res;
    }
}
