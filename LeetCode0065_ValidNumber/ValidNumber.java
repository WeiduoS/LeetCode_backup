package LeetCode0065_ValidNumber;

public class ValidNumber {
	 public boolean isNumber(String s) {
	        if(s == null || s.length() == 0) return false;
	        
	        //remove leading space
	        int i = 0, n = s.length();
	        while(i < n && Character.isWhitespace(s.charAt(i))) i++;
	        
	        // example: -53.5e-93
	        
	        // check the + / -
	        while(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
	        
	        // check before . numbers
	        boolean isDigits = false;
	        while(i < n && Character.isDigit(s.charAt(i))) {
	            i++;
	            isDigits = true;
	        }
	        
	        // check point part
	        if(i < n && s.charAt(i) == '.') {
	            i++;
	            while(i < n && Character.isDigit(s.charAt(i))) {
	                i++;
	                isDigits = true;
	            }
	        }
	        
	        if(i < n && s.charAt(i) == 'e' && isDigits) {
	            i++;
	            isDigits = false;
	            if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
	            while(i < n && Character.isDigit(s.charAt(i))) {
	                i++;
	                isDigits = true;
	            }
	        }
	        
	        // handle trailing space
	        while(i < n && Character.isWhitespace(s.charAt(i))) i++;
	        return isDigits && i == n;
	    }
}
