package LeetCode0482_LicenseKeyFormatting;

public class LicenseKeyFormatting {
	// Time Limited Exception
    /*
    public String licenseKeyFormatting(String S, int K) {
        String sb = "";
        for(char c : S.toCharArray()) {
            if(c != '-') sb += c;
        }
        sb = sb.toUpperCase();
        
        String res = "";
        int slash_index = sb.length() - K;
        for(int i = sb.length() - 1; i >= 0; i--) {
            res += sb.charAt(i);
            if(i == slash_index && i != 0) {
                slash_index -= K;
                res += "-";
            }
        }
        res = reverse(res);
        return res; 
    }
    
    private String reverse(String str) {
        String res = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }*/
    public String licenseKeyFormatting(String S, int K) {
        String result = S.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        
        int offset = result.length() % K;
        int counter = 0;
        //System.out.println(offset);
        for(int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if(i != 0 && i == offset || counter == K) {
                sb.append("-");
                counter = 0;
            }
            counter++;
            sb.append(c);
        }
        return sb.toString().toUpperCase();
    }
}
