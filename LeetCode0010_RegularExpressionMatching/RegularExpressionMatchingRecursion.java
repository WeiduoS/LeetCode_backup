package LeetCode0010_RegularExpressionMatching;

public class RegularExpressionMatchingRecursion {
	private static boolean solution(String s, String p) {
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		
		boolean first_match = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
		
		if(p.length() >= 2 && p.charAt(1) == '*') {
			return solution(s, p.substring(2)) || (first_match && solution(s.substring(1), p));
		}else {
			return first_match && solution(s.substring(1), p.substring(1));
		}
	}
	
	public static void main (String[] args) {
		//String s = "aa";
		//String p = "a";
		
		//String s = "aa";
		//String p = "a*";
		
		//String s = "abbcfd";
		//String p = "ab*c.d";

		String s = "aaa";
		String p = "a*";
		//RegularExpressionMatchingTopDown res = new RegularExpressionMatchingTopDown();
		boolean dp = solution(s, p);
		
		System.out.println(dp);
	}
}