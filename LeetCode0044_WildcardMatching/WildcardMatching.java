package LeetCode0044_WildcardMatching;

public class WildcardMatching {
//  Time Limit Exceeded 
    /*
    public boolean isMatch(String s, String p) {
        String pattern = "";
        boolean isFirst = true;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*') {
                if(isFirst) {
                    pattern += p.charAt(i);
                    isFirst = false;
                }
            }else{
                pattern += p.charAt(i);
                isFirst = true;
            }
        }
        return isMatchBacktracking(s, pattern);
    }
    private boolean isMatchBacktracking(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        
        if(p.length() > 1 && p.charAt(0) == '*' && s.length() == 0) return false;
        
        if(s.length() != 0 && ((p.length() != 0  && p.charAt(0) == '?') || (p.length() != 0 && p.charAt(0) == s.charAt(0)))) 
            return isMatchBacktracking(s.substring(1), p.substring(1));
        if(p.length() != 0 && p.charAt(0) == '*') 
            return isMatchBacktracking(s, p.substring(1)) || isMatchBacktracking(s.substring(1), p);
        return false;
    }*/
    
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        
        // replace multiple * with one * 
        // e.g a**b***c -> a*b*c
        int index = 0;
        boolean isFirst = true;
        for(int i = 0; i < pattern.length; i++) {
            if(pattern[i] == '*') {
                if(isFirst) {
                    pattern[index++] = pattern[i];
                    isFirst = false;
                }
            }else{
                pattern[index++] = pattern[i];
                isFirst = true;
            } 
        }
        
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        
        if(index > 0 && pattern[0] == '*') dp[0][1] = true;
        dp[0][0] = true;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pattern[j - 1] == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[str.length][index];
    }
}