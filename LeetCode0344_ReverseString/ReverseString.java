package LeetCode0344_ReverseString;

public class ReverseString {
	// extra space solution
    public String reverseStringI(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() == 0) return sb.toString();
        
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        
        
        return sb.toString();
    }
    
    // without any extra space
    public String reverseStringII(String s) {
        char[] res = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        return new String(res);
    }
    
    // using binary
    public String reverseStringIII(String s) {
        byte[] res = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            byte temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        return new String(res);
    }
    
    // using XOR
    public String reverseStringIV(String s) {
        char[] res = s.toCharArray();
        int i = 0;
        int j = res.length - 1;
        
        while(i < j){
            res[i] = (char) (res[i] ^ res[j]);
            res[j] = (char) (res[j] ^ res[i]);
            res[i] = (char) (res[i] ^ res[j]);
            i++;
            j--;
        }
        return new String(res);
    }
}