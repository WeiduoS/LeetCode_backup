package LeetCode0008_StringToInteger;

public class StringToInteger{
	private static int solution(String str) {
		
		int index = 0, sign = 1;
		double result = 0;
		
		//1. Remove Spaces
		str = str.trim();
		/*while(str.charAt(index) == ' ' && index < str.length() && str.length() != 1) {
			index ++;
			//System.out.println(index);
		}*/
		
		//2. Empty string
		if(str.length() == 0 || str == null) return 0;
		 
		//3. Handle signs
		if(str.charAt(index) == '+' || str.charAt(index) == '-'){
	        sign = str.charAt(index) == '+' ? 1 : -1;
	        index ++;
	    }
		
		//4. Convert number and avoid overflow
		for(int i = index; i < str.length(); i++) {
			
			if (str.charAt(i) < '0' || str.charAt(i) > '9' ) { 
                break; 
            }
			
			int digit = 0;
			digit = (int)str.charAt(i) - '0';
			result = result * 10 + digit;
			System.out.println(result);
		}
		
		//5. Avoid overflow
		
		if (sign == -1) { 
            result = -result; 
        } 
		
		if (result > Integer.MAX_VALUE) { 
            return Integer.MAX_VALUE; 
        } 
         
        if (result < Integer.MIN_VALUE) { 
            return Integer.MIN_VALUE; 
        } 
		return (int) result;

	}
	
	public static void main(String[] args) {
		//String s = "42"
		//String s = " ";
		//String s = "+";
		//String s = "-91283472332";
		String s = "-2147483648";
		int res = StringToInteger.solution(s);
		System.out.println(res);
	}
}