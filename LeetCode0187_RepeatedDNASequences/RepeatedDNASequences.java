package LeetCode0187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        int mask = 0;
        
        for(int i = 0; i < s.length(); i++) {
            mask = ((mask << 2) | map.get(s.charAt(i))) & 0xfffff;
            if(i < 9) continue;
            if(!set.contains(mask)) set.add(mask);
            else res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<>(res);
    }
}
