package LeetCode0246_StrobogrammaticNumber;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() - 1;
        while(l <= r) {
            if(!isValid(num.charAt(l), num.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    
    private boolean isValid(char i, char j) {
        if(i == '6') return j == '9';
        if(i == '9') return j == '6';
        if(i == '8') return j == '8';
        if(i == '0') return j == '0';
        if(i == '1') return j == '1';
        return false;
    }
}
