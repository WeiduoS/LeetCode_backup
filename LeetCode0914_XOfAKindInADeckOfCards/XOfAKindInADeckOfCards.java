package LeetCode0914_XOfAKindInADeckOfCards;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {
	public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int g = -1;
        for(Integer v : map.values()) {
            if(g == -1) {
                g = v;
            }else{
                g = gcd(g, v);
            }
        }
        return g >= 2;
    }
    
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
