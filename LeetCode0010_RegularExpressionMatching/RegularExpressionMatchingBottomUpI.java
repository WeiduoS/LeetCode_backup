package LeetCode0010_RegularExpressionMatching;

/*
 * Project name：leetcode 10 Regular Expression Matching
 * Author: Weiduo Sun
 * Date: 2018-7-7
 * Description: divide the problem into several cases
 * 
 */

public class RegularExpressionMatchingBottomUpI{
	
	/*
	 * '.' Matches any single character.
	 * '*' Matches zero or more of the preceding element.
	 * 1. s = "aa" p = "a" Output: false
	 * 2. s = "aa" p = "a*" Output: true
	 * 3. s = "ab" p = ".*" Output: true
	 * 4. s = "aab" p = "c*a*b" Output: true
	 * 5. s = "mississippi" p = "mis*is*p*." Output: false
	 * 
	 */
	/*	/  " a " --> 1 character
	 * a - " . " --> 1 character
	 * 	\  " {a-z} " + " * " --> 2 character 
	 * 
	 *  boolean match[i][j] means whether s[0 - i] matches p[0 - j ]
	 *  
	 *  1. p[j] is a new character
	 *  	match[i][j] == match[i-1][j-1]
	 *  2. p[j] is "."
	 *  	match[i][j] == match[i-1][j-1]
	 *  3. p[j] is "*"
	 *  	1. if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
	 *  	2，if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == ‘.’:
	 *  		dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
	 *  		dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
	 *  		dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
	 *  	
	 */
	
	private static boolean solution(String s, String p) {
		if(s == null || p == null) return false;
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;
		
		// Deal with patterns like a*, a*b*, or a*b*c*
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '*' && match[0][i-1]) {
				match[0][i+1] = true;
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < p.length(); j++) {
				if(p.charAt(j) == s.charAt(i)) {
					match[i+1][j+1] = match[i][j];
				}if(p.charAt(j) == '.') {
					match[i+1][j+1] = match[i][j];
				}if(p.charAt(j) == '*') {
					 if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
	                        match[i + 1][j + 1] = match[i + 1][j - 1];
	                    }else{
	                        match[i + 1][j + 1] = (match[i + 1][j] || match[i][j + 1] || match[i + 1][j - 1]);
	                    }
				}
			}
		}
		
		return match[s.length()][p.length()];		
	}
	
	public static void main(String[] args) {
		String s = "aa";
		String p = "a";
		
		boolean res = solution(s, p);
		
		System.out.println(res);
		
	}
	
}