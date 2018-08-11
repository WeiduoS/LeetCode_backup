package LeetCode0771_JewelsAndStones;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(char j : J.toCharArray()) set.add(j);
        for(char s : S.toCharArray()) {
            if(set.contains(s)) {
                res++;
            }
        }
        return res;
    }
}