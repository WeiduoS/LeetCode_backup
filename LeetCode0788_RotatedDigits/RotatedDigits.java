package LeetCode0788_RotatedDigits;

public class RotatedDigits {
	/*
    public int rotatedDigits(int N) {
        int res = 0;
        for(int i = 1; i <= N; i++) {
            if(valid(i)) res++;
        }
        return res;
    }
    
    private boolean valid(int n) {
        boolean flag = false;
        while(n != 0) {
            int t = n % 10;
            if(t == 3 || t == 4 || t == 7) return false;
            if(t == 2 || t == 5 || t == 6 || t == 9) flag = true;
            n /= 10;
        }
        return flag;
    }*/
    public int rotatedDigits(int N) {
        int res = 0;
        int[] dp = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            if(i < 10) {
                if(i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if(i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    res++;
                }
            }else{
                //比如四位数字abcd，可以拆分为三位数abc，和个位数d，如果abc翻转后仍是abc，d翻转后仍是d，说明abcd翻转后仍是abcd，所以dp[i]=1，
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    res++;
                }
            }
        }
        return res;
    }
}
