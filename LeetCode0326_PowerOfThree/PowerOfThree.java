package LeetCode0326_PowerOfThree;

public class PowerOfThree {
	private static final double epsilon = 10e-15;
    
    public boolean isPowerOfThree(int n) {
        if(0 == n)
            return false;
        double res = Math.log(n) / Math.log(3);
        return Math.abs(res - Math.round(res)) < epsilon;
        // return (n > 0 && int(log10(n) / log10(3)) - log10(n) / log10(3) == 0);
    }	
}