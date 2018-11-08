package LeetCode0680_ValidPalindromeII;

public class ValidPalindromeII {
	// Time Limitation Exception
    /*
    public boolean validPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i) + s.substring(i + 1);
            if(isPal(temp)) return true;
        }
        return isPal(s);
    }
    
    private boolean isPal(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }*/
    
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            /*
             * a c b b a -> a b b a
             * c a b b a -> a b b a
             */
            if(s.charAt(l) != s.charAt(r)) {
                return isPal(s, l + 1, r) || isPal(s, l, r - 1);
            }else if(s.charAt(l) == s.charAt(r)){
               l++;
                r--; 
            }
        }
        return true;
    }
    
    private boolean isPal(String s, int start, int end) {
        int l = start, r = end;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
