package LeetCode0014_longestCommonPrefix;

public class LongestCommonPrefixIII {
	private static String solution(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		
		for(int i = 0; i < strs.length; i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		String[] input = {"flower","flow","flight"};
		String res = solution(input);
		System.out.println(res);
	}
}