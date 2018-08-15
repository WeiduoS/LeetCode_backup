package LeetCode0279_PerfectSquares;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
	public int numSquaresI(int n) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int square = 1;
        while(square*square <= n) {
            queue.offer(square*square);
            set.add(square*square);
            square++;
        }
        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int temp = queue.poll();
                //System.out.println("res: " + res + ", temp: " + temp);
                if(temp == n) {
                    return res;
                }else{
                    for(int j = 1; j*j <= n; j++) {
                        if((temp + j*j) <= n && !set.contains(temp + j*j)) {
                            queue.offer(temp + j*j);
                            set.add(temp + j*j);
                        }
                    } 
                }
            }
        }
        return n;
	}
	public int numSquaresII(int n) {
        if(n <= 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {

            for(int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}