package LeetCode0214_ShortestPalindrome;

public class ShortestPalindrome {
	// https://www.youtube.com/watch?v=c4akpqTwE5g
    /*
    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        // use special character to avoid overlap
        // case: aaaaaaaa
        String l = s + "#" + rev_s;
        //System.out.println("l: " + l);
        int[] p = new int[l.length()];
        // build KMP table
        // i -> suffix boundary
        // j -> prefix boundary
        for(int i = 1; i < l.length(); i++) {
            // update prefix boundary
            int j = p[i - 1];
            //System.out.println("i :" + i + ", j: " + j);
            //System.out.println("l.charAt(i) :" + l.charAt(i) + ", l.charAt(j): " + l.charAt(j));
            // move to the last prefix boundary match
            while(j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            
            // if prefix boundary match suffix boundary, increase prefix length
            if(l.charAt(i) == l.charAt(j)) {
                p[i] = j + 1;
            }
        }
        //System.out.println(Arrays.toString(p));
        
        return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
    }*/
    
    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        
        String str = s + "#" + rev_s;
        int[]prefix = new int[str.length()];
        
        int index = 0;
        
        for(int i = 1; i < str.length();) {
            if(str.charAt(i) == str.charAt(index)) {
                prefix[i] = index + 1;
                i++;
                index++;
            }else{
                if(index != 0) {
                    index = prefix[index - 1];
                }else{
                    prefix[i] = 0;
                    ++i;
                }
            }
        }
        return rev_s.substring(0, s.length() - prefix[str.length() - 1]) + s;
    }
}
