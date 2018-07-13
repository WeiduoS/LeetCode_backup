package LeetCode0010_RegularExpressionMatching;


public class RegularExpressionMatchingBottomUpII {
	private static boolean solution(String s, String p) {
		boolean[][] match = new boolean[s.length()+1][p.length()+1];
		
		match[0][0] = true;
		
		// Deal with patterns like a*, a*b*, a*b*c*
		for(int i = 1; i <= p.length(); i++) {
			if(p.charAt(i-1) == '*') {
				match[0][i] = match[0][i-2];
			}
		}
		/*
		 * 				/ 1. match[i-1][j-1]: p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'
		 * match[i][j] =- 2. match[i][j-2]: p.chatAt(j) == '*' so '[a-z]*' equals to empty
		 * 				\ 3. match[i-1][j]:   p.chatAt(j) == '*' so p.chartAt(j-1) == s.charAt(i) || p.charAt(j) == '.' \\ a a a
		 * 																													a *
		 *     0 | 1 | 2 | 3 | 4 | 5 | 6 
		 *     ^ | x | a | * | b | . | c
		 * 0 ^ T | F | F | F | F | F | F 
		 * 1 x F | T | F | T | F | F | F
		 * 2 a F | F | T | T | F | F | F
		 * 3 a F | F | F | T | F | F | F 
		 * 4 b F | F | F | F | T | F | F
		 * 5 y F | F | F | F | F | T | F
		 * 6 c F | F | F | F | F | F | T
		 * 	 																												. *
		 *     0 | 1 | 2 |
		 *     ^ | a | * |
		 * 0 ^ 
		 * 1 a 
		 * 2 a
		 * 3 a	
		 */
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') {
					match[i][j] = match[i-1][j-1];
				}else if(p.charAt(j-1) == '*') {
					match[i][j] = match[i][j-2];
					if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
						match[i][j] = match[i][j-2] || match[i-1][j];
					}
				}else {
					match[i][j] = false;
				}
			}
		}
		for(int i = 0; i <= s.length(); i++) {
			for(int j = 0; j <= p.length(); j++) {
				System.out.println("match[" + i + "][" + j + "]:" + match[i][j]);
			}
				
		}
		return match[s.length()][p.length()];
	}
	
	public static void main (String[] args) {
		//String s = "aa";
		//String p = "a";
		
		String s = "aaa";
		String p = "a*";
		
		boolean res = solution(s, p);
		
		System.out.println(res);
	}
}