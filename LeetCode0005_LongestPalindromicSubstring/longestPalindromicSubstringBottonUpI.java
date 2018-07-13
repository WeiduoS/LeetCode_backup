package LeetCode0005_LongestPalindromicSubstring;

public class longestPalindromicSubstringBottonUpI{
	private static String solution(String s) {
		 int start = 0, end = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int len1 = solutionExtend(i, i, s);
			int len2 = solutionExtend(i, i + 1, s);
			int len = Math.max(len1, len2);
			
			 if (len > end - start) {
				 start = i - (len - 1) / 2;
		         end = i + len / 2;
			 }		
		}
		 return s.substring(start, end + 1);
	}
	
	private static int solutionExtend(int left, int right, String s) {
		int L = left, R = right;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}		
		// R plus 1 more and L minus one more
		return R - L - 1;
	}
	
	public static void main(String[] args) {
		//String s = "babad";
		//String s = "cbbd";
		//String s = "qqyuqq";
		//String s = "aaaa";
		String s ="a";
		String res = "";
		res = longestPalindromicSubstringBottonUpI.solution(s);
		System.out.println(res);
	}
}