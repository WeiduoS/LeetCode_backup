package LeetCode0003_LongestSubstringWithoutRepeatingChatarcters;

import java.util.HashSet;
import java.util.Set;


public class longestSubstringWithoutRepeatingCharatchersSlidingWindow{
	private static int solution (String s) {
		int n = s.length();
		int maxLen = 0, i = 0, j = 0;
		Set<Character> set = new HashSet<>();
		while ( i < n && j < n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				maxLen = (maxLen >= (j - i))? maxLen : (j - i);
			}else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		int ans = longestSubstringWithoutRepeatingCharatchersSlidingWindow.solution(s);
		System.out.println("Longest Substring WithoutRepeating Charatchers:" + ans);
	}
}