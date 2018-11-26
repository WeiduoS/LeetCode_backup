package LeetCode0948_BagOfTokens;

import java.util.Arrays;

public class BagOfTokens {
	public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int points = 0, ans = 0;
        
        while (l <= r && (P >= tokens[l] || points > 0)) { // we have points or the current token is available
            while(l <= r && tokens[l] <= P) {
                P -= tokens[l++];
                points++;
            }
            ans = Math.max(points, ans);
            if(l <= r && points > 0) {
                P += tokens[r--];
                points--;
            }
        }
        return ans;
    }
}
