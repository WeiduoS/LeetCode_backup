package LeetCode0792_NumberOfMatchingSubsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {
	public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            map.computeIfAbsent(S.charAt(i), x -> new ArrayList<>());
            map.get(S.charAt(i)).add(i);
        }
        int res = 0;
        for(String s : words) {
            if(match(s, map)) res++;
        }
        return res;
    }
    
    private boolean match(String str, Map<Character, List<Integer>> map) {
        int end = -1;
        for(char c : str.toCharArray()) {
            if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            int index = Collections.binarySearch(list, end + 1);
            if(index < 0) index = -index - 1;
            if(index >= list.size()) return false;
            end = list.get(index);
        }
        return true;
    }
}
