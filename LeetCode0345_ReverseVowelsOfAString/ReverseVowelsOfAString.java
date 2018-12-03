package LeetCode0345_ReverseVowelsOfAString;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
	Set<Character> set = new HashSet<>();
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public String reverseVowels(String s) {
        for(char c : vowels) set.add(c);
        
        int l = 0, r = s.length() - 1;
        char[] c = s.toCharArray();
        
        while(l < r) {
            while(l < r && !set.contains(c[l])) l++;
            while(l < r && !set.contains(c[r])) r--;
            //System.out.println("c[l]: " + c[l] + ", c[r]: " + c[r]);
            if(l < r && set.contains(c[l]) && set.contains(c[r])) {
                c[l] = (char)(c[l] ^ c[r]);
                c[r] = (char)(c[l] ^ c[r]);
                c[l] = (char)(c[l] ^ c[r]);
                l++;
                r--;
            }
        }
        return new String(c);
    }
}
