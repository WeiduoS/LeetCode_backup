package LeetCode0186_ReverseWordsInAStringII;

public class ReverseWordsInAStringII {
	public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        for(int i = 0, j = 0; i < str.length; i++) {
            //System.out.println("i: " + i + ", j: " + j);
            while(j < str.length && str[j] != ' ') j++;
            reverse(str, i, j - 1);
            i = j;
            j++;
        }
    }
    
    private void reverse(char[] str, int l, int r) {
        while(l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
        return;
    }
}