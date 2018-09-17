package LeetCode0242_ValidAnagram;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] characters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            characters[s.charAt(i) - 'a']++;
            characters[t.charAt(i) - 'a']--;
        }
        for(Integer i : characters) {
            if(i != 0) return false;
        }
        
        return true;
    }	
}