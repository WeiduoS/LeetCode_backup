package LeetCode0050_Pow;

public class Pow {
	// Solution 1: Recursive

    public double myPowI(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) x = 1 / x;
        return half(x, n);
    }
    private double half(double x, int n) {
        double res = 1.0;
        if(n == 1 || n == -1) {
            return x;
        }
        double half = half(x, n / 2);
        if(n % 2 == 0) {
            res = half* half;
        }else{
            res = half * half * x;
        }
        return res;
    }
    //Solution 2: Iterative
    public double myPowII(double x, int n) {
        if(n == 0) return 1.0;
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double base = x;
        for(long i = N; i > 0; i /= 2) {
            if(i % 2 == 1) {
                ans = ans * base;
            }
            base = base * base;
        }

        return ans;
    }	
}