package LeetCode0524_LongestWordInDictionaryThroughDeleting;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	/*
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2); 
            }
        });
        //String res = "";
        for(String str : d) {
            int j = 0;
            for(int i = 0; i < s.length() && j < str.length(); i++) {
                if(s.charAt(i) == str.charAt(j)) j++;
            }
            if(j == str.length()) return str;
        }
        
        return "";
    }*/
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String str : d) {
            int j = 0;
            for(char c : s.toCharArray()) {
                if(j < str.length() && c == str.charAt(j)) j++;
            }
            if(j == str.length() && str.length() >= res.length()) {
                if(str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) res = str;
            }
        }
        return res;
    }
}
