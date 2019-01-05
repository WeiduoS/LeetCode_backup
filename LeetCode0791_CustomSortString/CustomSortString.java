package LeetCode0791_CustomSortString;

public class CustomSortString {
	public String customSortString(String S, String T) {
        String res = "";
        int[] chars = new int[26];
        for(char c : T.toCharArray()) chars[c - 'a']++;
        for(char c : S.toCharArray()) {
            while(chars[c - 'a']-- > 0) res += c;
        }
        for(char c : T.toCharArray()) {
            while(chars[c - 'a']-- > 0) res += c;
        }
        return res;
    }
}
