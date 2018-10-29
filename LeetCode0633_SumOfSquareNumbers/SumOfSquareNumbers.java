package LeetCode0633_SumOfSquareNumbers;

public class SumOfSquareNumbers {
	/*
    public boolean judgeSquareSum(int c) {
        for(long i = 0; i * i <= c; i++) {
            double x = Math.sqrt(c - i * i);
            if(x == (int) x) return true;
        }
        return false;
    }*/
    /*
    public boolean judgeSquareSum(int c) {
        for(long i = 0; i * i <= c; i++) {
            long x = c - i * i;
            long l = 0, r = x;
            while(l <= r) {
                long m = l + (r - l) / 2;
                if(m * m == x) return true;
                else if(m * m > x) r = m - 1;
                else l = m + 1;
            }
        }
        return false;
    }*/
    
    // Fermat Theorem 
    /* Any positive number n is expressible as a sum of two squares if and only if the prime factorization of n, every prime of        * the form (4k+3) occurs an even number of times.
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }	
}