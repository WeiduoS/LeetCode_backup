package LeetCode0829_ConsecutiveNumbersSum;

public class ConsecutiveNumbersSum {
	public int consecutiveNumbersSum(int N) {
        /** (x + (x + k - 1)) * k / 2 = N
          * (2x + k - 1) * k = 2N
          * x * k + (k - 1) * k / 2 = N
          * xk = N - k(k - 1) / 2;
          */
        int res = 0;
        for(int k = 1; ; k++) {
            int xk = N - k * (k - 1) / 2;
            if(xk <= 0) break;
            if(xk % k == 0) res++;
        }
        return res;
    }
}
