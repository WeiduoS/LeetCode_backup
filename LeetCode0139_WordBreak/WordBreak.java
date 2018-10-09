package LeetCode0139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	 // solution 1: backtracking
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        return backTracking(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    private boolean backTracking(String s, Set<String> wordDict, int start, Boolean[] isWord) {
        if(start == s.length()) return true;
        if(isWord[start] != null) return isWord[start];
        for(int i = start + 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(start, i)) && backTracking(s, wordDict, i, isWord)) {
                return isWord[start] = true;
            }
        }
        return isWord[start] = false;
    }*/
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= dp.length - 1; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }	
}