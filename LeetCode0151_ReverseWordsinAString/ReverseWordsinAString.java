package LeetCode0151_ReverseWordsinAString;

public class ReverseWordsinAString {
	// Solution 1
    public String reverseWordsI(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
    
    // Solution 2
    public String reverseWordsII(String s) {
        if(s == null) return null;
        char[] words = s.toCharArray();
        int len = words.length;
        
        reverse(words, 0 , len - 1);
        reverseWord(words, len);
        return cleanSpaces(words, len);
    }
    
    private static void reverse(char[] words, int start, int end) {
        while(start < end) {
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }
    
    private static void reverseWord(char[] words, int len) {
        int start = 0;
        int end = 0;
        
        while(start < len){
            while(start < end || start < len && words[start] == ' ') start++;
            while(end < start || end < len && words[end] != ' ') end++;
            reverse(words, start, end - 1);
        }
    }
    
    private static String cleanSpaces(char[] words, int len) {
        int i = 0, j = 0;
        
        while(j < len) {
            while(j < len && words[j] == ' ') j++;
            while(j < len && words[j] != ' ') words[i++] = words[j++];
            while(j < len && words[j] == ' ') j++;
            if (j < len) words[i++] = ' ';
        }
        return new String(words).substring(0, i);
    }
    
    
    
}