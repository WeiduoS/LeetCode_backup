package LeetCode0003_LongestSubstringWithoutRepeatingChatarcters;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharatchersBruteForce{
	private static int solution(String s) {
		int n = s.length();
		int maxLen = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j <= n; j++) {
				if(uniqueChar(s, i, j)) maxLen = (maxLen >= (j - i))? maxLen : (j - i);
			}
		}
		return maxLen; 
	}
	
	private static boolean uniqueChar(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for(int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if(set.contains(ch)) return false;
			set.add(ch);
		}
		return true;		
	}
	
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		int ans = longestSubstringWithoutRepeatingCharatchersBruteForce.solution(s);
		System.out.println("Longest Substring WithoutRepeating Charatchers:" + ans);
	}
}