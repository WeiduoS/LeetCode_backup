package LeetCode0906_SuperPalindromes;

public class SuperPalindromes {
	public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L), r = Long.valueOf(R);
        // 31623 == 10 ^ 4.5
        int res = 0;
        for(long i = 1; i <= 31623; i++) {
            for(int j = 0; j <= 1; j++) {
                String str = String.valueOf(i);
                int n = str.length();
                for(int k = n - j - 1; k >= 0; k--) {
                    str += str.charAt(k);
                }
                long p1 = Long.valueOf(str);
                long p2 = p1 * p1;
                if(l <= p2 && p2 <= r && isPalindrome(p2)) {
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(long x) {
        String str = String.valueOf(x);
        int l = 0, r = str.length() - 1;
        while(l < r) {
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}
