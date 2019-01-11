package LeetCode0940_DistinctSubsequencesII;

public class DistinctSubsequencesII {
	public int distinctSubseqII(String S) {
        long[] chars = new long[26];
        long mod = (long)1e9 + 7;
        for(char c : S.toCharArray()) {
            long delta = 0;
            for(long i : chars) delta = (delta + i) % mod;
            chars[c - 'a'] = delta + 1;
        }
        long sum = 0;
        for(long i : chars) sum += i;
        return (int)(sum % mod);
    }
}
