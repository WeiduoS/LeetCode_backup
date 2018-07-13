package LeetCode0003_LongestSubstringWithoutRepeatingChatarcters;

import java.util.HashMap;
import java.util.Map;

public class longestSubstringWithoutRepeatingCharatchersHashMap{
	private static int solution(String s) {
		int n = s.length();
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0, j = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				i = (map.get(s.charAt(j)) >= (j - i))? map.get(s.charAt(j)) : (j - i);
			}
			maxLen = (maxLen >= (j - i))? maxLen : (j - i);
			map.put(s.charAt(j), j);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		int ans = longestSubstringWithoutRepeatingCharatchersHashMap.solution(s);
		System.out.println("Longest Substring WithoutRepeating Charatchers:" + ans);
	}
}