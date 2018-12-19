package LeetCode0527_WordAbbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordAbbreviation {
	public List<String> wordsAbbreviation(List<String> dict) {
        int n = dict.size();
        List<String> res = new ArrayList<>();
        int[] pre = new int[n];
        Arrays.fill(pre, 1);
        for(int i = 0; i < n; i++) {
            res.add(abbr(dict.get(i), pre[i]));
        }
        for(int i = 0; i < n; i++) {
            while(true) {
                Set<Integer> set = new HashSet<>();
                for(int j = i + 1; j < n; j++) {
                    if(res.get(i).equals(res.get(j))) set.add(j);
                }
                if(set.size() == 0) break;
                set.add(i);
                for(int index : set) {
                    res.set(index, abbr(dict.get(index), ++pre[index]));
                }
            }
        }
        return res;
    }
    
    private String abbr(String s, int k) {
        int n = s.length();
        if(k >= n - 2) return s;
        String temp = s.substring(0, k) + (n - k - 1) + s.substring(n - 1);
        return temp;
    }
}
