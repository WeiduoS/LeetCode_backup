package LeetCode0647_PalindromicSubstrings;

public class PalindromicSubstrings {
	/*
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i <= n * 2 - 1; i++) {
            int left = i / 2;
            int right = i % 2 == 0 ? left + 1 : left;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                res++;
            }
        }
        return res;
    }*/
    /*
    public int countSubstrings(String s) {
        String res = helper(s);
        
        int n = res.length();
        int[] arr = new int[n];
        int c = 0, r = 0;
        for(int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * c - i;
            
            arr[i] = (r > i) ? Math.min(r - i, arr[i_mirror]) : 0;
            
            while(res.charAt(i + 1 + arr[i]) == res.charAt(i - 1 - arr[i])) arr[i]++;
            
            if(i + arr[i] > r) {
                c = i;
                r = i + arr[i];
            }
        }
        
        int cnt = 0;
        for(int i : arr) cnt += (i + 1) / 2;
        return cnt;
    }
    
    private String helper(String s) {
        int n = s.length();
        String res = "^";
        if(n == 0) return "^$";
        for(int i = 0; i < n; i++) {
            res = res + "#" + s.charAt(i);
        } 
        res += "#$";
        
        return res;
    }*/
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(i - j < 3) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = dp[i - 1][j + 1] && s.charAt(i) == s.charAt(j);
                }
                if(dp[i][j]) res++;
            }
        }
        return res;
    }
}
