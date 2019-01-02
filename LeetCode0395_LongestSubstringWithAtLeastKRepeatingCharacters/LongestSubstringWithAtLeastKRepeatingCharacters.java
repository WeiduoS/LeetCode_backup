package LeetCode0395_LongestSubstringWithAtLeastKRepeatingCharacters;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
	/*
    public int longestSubstring(String s, int k) {
        int res = 0, i = 0, n = s.length();
        while(i + k <= n) {
            int[] chars = new int[26];
            int mask = 0, max_idx = i;
            for(int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                chars[c]++;
                if(chars[c] < k) mask |= (1 << c);
                else mask &= (~(1 << c));
                if(mask == 0) {
                    res = Math.max(res, j - i + 1);
                    max_idx = j;
                }
            }
            i = max_idx + 1;
        }
        return res;
    }*/
    /*
    public int longestSubstring(String s, int k) {
        int res = 0;
        for(int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }
    
    private int helper(String s, int k, int numUniqueTarget) {
        int[] count = new int[128];
        int start = 0, end = 0;
        int numUnique = 0, noLessThanK = 0;
        int res = 0;
        
        while(end < s.length()) {
            if(count[s.charAt(end)]++ == 0) numUnique++;
            if(count[s.charAt(end++)] == k) noLessThanK++;
            
            while(numUnique > numUniqueTarget) {
                if(count[s.charAt(start)]-- == k) noLessThanK--;
                if(count[s.charAt(start++)] == 0) numUnique--;
            }
            
            if(numUnique == noLessThanK && numUnique == numUniqueTarget) {
                res = Math.max(end - start, res);
            }
        }
        return res;
    }*/
    
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean valid = false, flag = false;
        for(int i : count) {
            if(i >= k) valid = true;
            if(i > 0 && i < k) flag = true;
            if(valid && flag) break;
        }
        if(!valid) return 0;
        if(!flag) return s.length();
        
        int res = 0, i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(count[s.charAt(j) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(i, j), k));
                i = j + 1;
            }
        }
        res = Math.max(res, longestSubstring(s.substring(i), k));
        return res;
    }
}
