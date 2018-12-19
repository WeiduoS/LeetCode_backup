package LeetCode0809_ExpressiveWords;

public class ExpressiveWords {
	/*
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word : words) {
            if(isValid(S, word)) res++;
        }
        return res;
    }
    
    private boolean isValid(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        for(i = 0; i < s.length(); i++) {
            if(j < m && s.charAt(i) == t.charAt(j)) {
                j++;
            }else if(i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)){
                continue;
            }else if(i > 0 && i < n - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1)) {
                continue;
            }else{
                return false;
            }
        }
        return j == m;
    }*/
    
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word : words) {
            if(isValid(S.toCharArray(), word.toCharArray())) res++;
        }
        return res;
    }
    
    private boolean isValid(char[] s, char[] t) {
        // 如果当前的s[i] != t[j], 直接返回false
        // 统计当前连续相同的字符分别用cntT和cntS表示
        // 如果cntT == cntS,说明是严格匹配,当然可以继续
        // 如果cntT < cntS && cntS >= 3, 说明 S extend了当前的字符,也可以继续匹配
        int i = 0, j = 0;
        while(i < s.length && j < t.length) {
            if(s[i++] != t[j++]) return false;
            int cntT = 1, cntS = 1;
            while(i < s.length && s[i] == s[i - 1]) {
                i++;
                cntS++;
            }
            while(j < t.length && t[j] == t[j - 1]) {
                j++;
                cntT++;
            }
            if(cntT == cntS || (cntS > cntT && cntS >= 3)) continue;
            return false;
        }
        return i == s.length && j == t.length;
    }
}
