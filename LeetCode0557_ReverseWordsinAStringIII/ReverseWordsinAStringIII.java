package LeetCode0557_ReverseWordsinAStringIII;

public class ReverseWordsinAStringIII {
	public String reverseWords(String s) {
        int len = s.length(); 
        char[] words = s.toCharArray();
        int i = 0;
        while(i < len){
            int j = i;
            while(j < len && words[j] != ' '){
                j++;
            }
            reverse(words, i, j - 1);
            i = j + 1;
        }
    
        return new String(words);
    }
    
    private static void reverse(char[] words, int i, int j){
        while(i < j){
            char t = words[i];
            words[i] = words[j];
            words[j] = t;
            i++;
            j--;
        }
    }
}