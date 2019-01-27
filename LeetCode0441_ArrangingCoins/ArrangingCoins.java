package LeetCode0441_ArrangingCoins;

public class ArrangingCoins {
	// Time Limit Exceeded
    /*
    public int arrangeCoins(int n) {
        int i = 1;
        while((i + i * i) / 2 <= n) {
            //System.out.println("i: " + i);
            i++;
        }
        return i - 1;
    }*/
    /*
    public int arrangeCoins(int n) {
        if(n == 1) return 1;
        long l = 1, r = n;
        while(l < r) {
            long m = l + (r - l) / 2;
            long temp = (m + m * m) / 2;
            //System.out.println("l: " + l + ", r: " + r);
            if(temp == n) return (int)m;
            if(temp < n) l = m + 1;
            else r = m;
        }
        return (int)(l - 1);
    }*/
    public int arrangeCoins(int n) {
        return (int)(-1 + Math.sqrt(1 + 8 * (long)n) ) / 2; 
    }
}
