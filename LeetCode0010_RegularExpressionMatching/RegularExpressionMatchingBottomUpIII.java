package LeetCode0010_RegularExpressionMatching;

public class RegularExpressionMatchingBottomUpIII{
	private static boolean solution(String s, String p) {
		
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		
		/*
		 *         | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
		 *         | a | b | * | c | . | d | $ |
		 *   0 | a | T | F | F | F | F | F | F |                       
		 *   1 | b | F | T | F | F | F | F | F |
		 *   2 | b | F | T | F | F | F | F | F |
		 * * 3 | c | F | T | F | T | F | F | F |
		 *   4 | f | F | F | F | F | T | F | F |
		 *   5 | d | F | F | F | F | F | T | F |
		 *   6 | $ | F | F | F | F | F | F | T |
		 *   
		 *   
		 *   
		 *   0 1 2 3 4 5 
		 *         *    
		 *   a b b c f d
		 *     *
		 *   a b * c . d
		 *   
		 *   
		 */
		
		for(int i = s.length(); i >= 0; i-- ) {
			for(int j = p.length() - 1; j >=0; j--) {
				boolean first_match  = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
				
				if(j + 1 < p.length() && p.charAt(j+1) == '*') {
					/* 
					 *  match[i][j] = match[i][j+2]
					 *  0 1 2 3 4 5 6
					 *            i
					 *  a b b c f d $
					 *    j
					 *  a b * c . d $
					 *  
					 *  match[i][j] = p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'
					 *  0 1 2 3 4 5 6
					 *      i
					 *  a b b c f d $
					 *    j
					 *  a b * c . d $
					 *           
					 */
					
					match[i][j] = match[i][j+2] || first_match && match[i+1][j];
				}else{
					match[i][j] = first_match && match[i+1][j+1]; 
				}
			}
		}
		
		for(int i = 0; i <= s.length(); i++) {
			for(int j = 0; j <= p.length(); j++) {
				System.out.println("match[" + i + "][" + j + "]:" + match[i][j]);
			}
				
		}
		return match[0][0];
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
		
		boolean res = solution(s, p);
		
		System.out.println(res);
	}
}