package LeetCode0204_CountPrimes;

public class CountPrimes{
	public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for(int i = 2; i < Math.sqrt(n); i++) {
            if(!notPrimes[i]) {
                for(int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        for(int i = 2; i < n; i++) {
            if(!notPrimes[i]) count++;
        }
        return count;
    }	
}