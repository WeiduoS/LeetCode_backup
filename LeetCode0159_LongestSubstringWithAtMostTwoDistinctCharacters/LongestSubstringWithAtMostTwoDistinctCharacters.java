package LeetCode0159_LongestSubstringWithAtMostTwoDistinctCharacters;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] characters = new int[256];
        int unique = 0;
        int max = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(characters[c] == 0) unique++;
            characters[c]++;
            while(unique > 2) {
                char t = s.charAt(i++);
                characters[t]--;
                if(characters[t] == 0) unique--;
            }
            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}
