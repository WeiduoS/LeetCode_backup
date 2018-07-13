package LeetCode0014_longestCommonPrefix;

public class LongestCommonPrefixI {
	private static String solution(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		
		String lcp = strs[0];
		
		for(int i = 1; i < strs.length; i++) {
			while(strs[i] .indexOf(lcp) != 0) {
				lcp = lcp.substring(0, lcp.length() - 1);
				if(lcp.isEmpty()) return "";
			}
		}
		
		return lcp;
	}
	
	public static void main(String[] args) {
		String[] input = {"flower","flow","flight"};
		String res = solution(input);
		System.out.println(res);
	}
}