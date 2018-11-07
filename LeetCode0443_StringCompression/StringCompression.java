package LeetCode0443_StringCompression;

public class StringCompression{
	public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        
        int k = 0;
        for(int i = 0, j = 0; j < chars.length;) {
            while(j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            int counts = j - i ;
            // record the answer  
            chars[k] = chars[i];
            k++;
            if(counts != 1) {
                for(char c : Integer.toString(counts).toCharArray()) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}