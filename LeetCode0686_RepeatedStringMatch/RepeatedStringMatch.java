package LeetCode0686_RepeatedStringMatch;

public class RepeatedStringMatch {
	/*
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int times = 1;
        while(sb.length() < B.length()) {
            times++;
            sb.append(A);
        }
        
        if(sb.indexOf(B) == -1) {
            sb.append(A);
            times++;
        }else{
            return times;
        }
        
        return sb.indexOf(B) == -1 ? -1 : times;
    }*/
    
    public final static int d = 256;
    public final static int prime_mod = 101;
    
    public int repeatedStringMatch(String A, String B) {
        int pattern_len = A.length(), txt_len = B.length();
        
        int txt_hash_value = 0;
        int pat_hash_value = 0;
        
        int h = 1;
        
        for(int i = 0; i < txt_len - 1; i++) h = (h * d) % prime_mod;
        
        for(int i = 0; i < txt_len; i++) {
            txt_hash_value = (txt_hash_value * d + B.charAt(i)) % prime_mod;
            pat_hash_value = (pat_hash_value * d + A.charAt(i % A.length())) % prime_mod;
        }
        
        //System.out.println("txt_hash_value: " + txt_hash_value);
        //System.out.println("pat_hash_value: " + pat_hash_value);
        
        int res = (B.length() - 1) / A.length() + 1;

        int M = A.length() * (res + 1);
        for(int i = 0; i < M; i++) {
            if(txt_hash_value == pat_hash_value && check(i, A, B)) {
                return i + txt_len <= res * A.length() ? res : res + 1;
            }
            //System.out.println("i: " + i + ", A1: " + A.charAt(i % pattern_len));
            //System.out.println("i: " + i + ", A2: " + A.charAt((i + txt_len) % pattern_len));
            
            pat_hash_value = ((pat_hash_value - A.charAt(i % pattern_len) * h) * d + A.charAt((i + txt_len) % pattern_len)) % prime_mod;
            if (pat_hash_value < 0) pat_hash_value = (pat_hash_value + prime_mod); 
        }
        
        return -1;
    }
    
    private boolean check(int index, String A, String B) {
        for(int i = 0; i < B.length(); i++) {
            if(A.charAt((i + index) % A.length()) != B.charAt(i)) return false;
        }
        return true;
    }
}
