package LeetCode0009_PalndromeNumber;

public class PalindromeNumber{
	private static boolean solution (int x) {
		
		if (x < 0 || x != 0 && x % 10 == 0) {
		      return false;
		    }
		
		int reversed = 0;
        int original = x;
       
        while(original != 0 ){
            reversed = reversed * 10 + original % 10;
            original = original / 10;
        }
        
        return x == reversed; 
	}
	
	public static void main(String[] args) {
		int n = 121;
		boolean res; 
		
		res = PalindromeNumber.solution(n);
		System.out.println(res);
	}
}