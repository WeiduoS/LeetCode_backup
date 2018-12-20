package LeetCode0424_LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        int[] characters = new int[26];
        char[] str = s.toCharArray();
        int majCnt = 0, res = 0, n = s.length();
        for(int i = 0, j = 0; j < n; j++) {
            characters[str[j] - 'A']++;
            majCnt = Math.max(majCnt, characters[str[j] - 'A']);
            while(j - i + 1 - majCnt > k) {
                characters[str[i] - 'A']--;
                i++;
            }
            //System.out.println("i: " + i + ", j: " + j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
