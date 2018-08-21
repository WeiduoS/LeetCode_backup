package LeetCode0374_GuessNumberHigherOrLower;

public class GuessNumberHigherOrLower {
	public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int res = guess(m);
            if(res == 0) {
                return m;
            }else if(res < 0) {
                r = m - 1;
            }else if(res > 0) {
                l = m + 1;
            }
        }
        return -1;
    }
	private int guess(int n) {
		if(n == 6) return 0;
		if(n > 6) return 1;
		return -1;
	}
	
}