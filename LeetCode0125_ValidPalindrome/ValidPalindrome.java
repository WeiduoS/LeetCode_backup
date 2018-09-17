package LeetCode0125_ValidPalindrome;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = s.toLowerCase();
        for(char c : temp.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        //System.out.println(sb.toString());
        int i = 0;
        int j = sb.length() - 1;
        while(i < j) {
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }	
}