package LeetCode0014_longestCommonPrefix;

public class LongestCommonPrefixII{
	private static String solution(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		 
		String lcp = strs[0];
		
		for(int i = 1; i < strs.length; i++) {
			int j = 0;
			
			while(j < lcp.length() && j < strs[i].length() && lcp.charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			
			if(j == 0) {
				return "";
			}
			lcp = lcp.substring(0, j);
		}
		return lcp;
	}
	
	public static void main(String[] args) {
		String[] input = {"flower","flow","flight"};
		String res = solution(input);
		System.out.println(res);
	}
}