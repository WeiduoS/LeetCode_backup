package LeetCode0003_LongestSubstringWithoutRepeatingChatarcters;

public class longestSubstringWithoutRepeatingCharatchersHashMapASCII {
	private static int solution (String s) {
		int n = s.length();
		int maxLen = 0;
		int[] index = new int[128];
		for (int j = 0, i = 0; j < n; j++) {
            i = (index[s.charAt(j)] >= i)? index[s.charAt(j)] : i;
            maxLen = (maxLen >= (j - i + 1)) ? maxLen : (j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return maxLen;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		int ans = longestSubstringWithoutRepeatingCharatchersHashMapASCII.solution(s);
		System.out.println("Longest Substring WithoutRepeating Charatchers:" + ans);
	}
	
}