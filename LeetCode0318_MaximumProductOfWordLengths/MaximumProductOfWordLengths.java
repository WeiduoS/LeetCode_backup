package LeetCode0318_MaximumProductOfWordLengths;

public class MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                mask[i] |= 1 << c - 'a';
            }
            
            for(int j = 0; j < i; j++) {
                if((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
