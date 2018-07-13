package LeetCode0010_RegularExpressionMatching;

enum Result {
    TRUE, FALSE
}

public class RegularExpressionMatchingTopDown{
	Result[][] memo;
	
	private boolean solution(String s, String p) {
		memo = new Result[s.length() + 1][p.length() + 1];
		return solutionExtend(0, 0, s, p);
	}
	
	public boolean solutionExtend(int i, int j, String text, String pattern) {
		
		if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
		
		boolean ans;
		
		if(j == pattern.length()) {
			ans = i == text.length();
		}else {
			boolean first_match = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'); 
			
			if(j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
				ans = (solutionExtend(i, j + 2, text, pattern) || first_match && solutionExtend(i + 1, j, text, pattern));
			}else {
				 ans = first_match && solutionExtend(i+1, j+1, text, pattern);
			}
			
		}
		
		memo[i][j] = ans ? Result.TRUE : Result.FALSE;
		 return ans;
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
		RegularExpressionMatchingTopDown res = new RegularExpressionMatchingTopDown();
		boolean dp = res.solution(s, p);
		
		System.out.println(dp);
	}
}