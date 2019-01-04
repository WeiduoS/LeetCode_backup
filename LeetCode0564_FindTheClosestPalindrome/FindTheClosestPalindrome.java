package LeetCode0564_FindTheClosestPalindrome;

import java.util.HashSet;
import java.util.Set;

public class FindTheClosestPalindrome {
	public String nearestPalindromic(String n) {
        long len = n.length(), num  = Long.valueOf(n), res = 0, minDiff = Long.MAX_VALUE;
        Set<Long> set = new HashSet<>();
        set.add((long)(Math.pow(10, len) + 1));
        set.add((long)(Math.pow(10, len - 1) - 1));
        
        long prefix = Long.valueOf(n.substring(0, (int)(len + 1) / 2));
        
        for(long i = -1; i <= 1; i++) {
            String left = String.valueOf(prefix + i);
            String right = new StringBuilder(left).reverse().toString();
            if(len % 2 == 1) right = right.substring(1);
            String str = left + right;
            set.add(Long.valueOf(str));
        }
        set.remove(num);
        for(long a : set) {
            long diff = Math.abs(a - num);
            if(diff < minDiff) {
                minDiff = diff;
                res = a;
            }else if(diff == minDiff) {
                res = Math.min(res, a);
            }
        }
        return String.valueOf(res);
    }
}
