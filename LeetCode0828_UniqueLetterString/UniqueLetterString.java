package LeetCode0828_UniqueLetterString;

public class UniqueLetterString {
	public int uniqueLetterString(String S) {
        if(S == null || S.length() == 0) return 0;
        long res = 0, mod = (long)(1e9 + 7), N = S.length();
        
        int[] left = new int[26];
        int[] mid = new int[26];
        int[] right = new int[26];
        
        for (int i = 0; i < left.length; i++) left[i] = mid[i] = right[i] = -1;
        
        for(int i = 0; i < N; i++) {
            int c = S.charAt(i) - 'A';
            left[c] = mid[c];
            mid[c] = right[c];
            right[c] = i;
            if(mid[c] != -1) res = (res + (mid[c] - left[c]) * (right[c] - mid[c])) % mod;
        }
        
        for(int i = 0; i < 26; i++) {
            if(right[i] != -1) res = (res + (N - right[i]) * (right[i] - mid[i])) % mod;
        }
        
        return (int)res;
    }
}
