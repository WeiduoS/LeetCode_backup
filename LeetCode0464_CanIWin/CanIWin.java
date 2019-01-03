package LeetCode0464_CanIWin;

public class CanIWin {
	int[] states; // 0: unknow, 1: can win; -1: can not win
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum  = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        states = new int[1 << maxChoosableInteger];
        return helper(maxChoosableInteger, desiredTotal, 0);
    }
    
    private boolean helper(int M, int T, int state) {
        if(T <= 0) return false;
        if(states[state] != 0) return states[state] == 1;
        
        for(int i = 0; i < M; i++) {
            if((state & (1 << i)) > 0) continue;// number i used
            // The next player can not win, current player wins
            if(!helper(M, (T - (i + 1)), state | (1 << i))) {
                states[state] = 1;
                return true;
            }
        }
        states[state] = -1;
        return false;
    }
}
