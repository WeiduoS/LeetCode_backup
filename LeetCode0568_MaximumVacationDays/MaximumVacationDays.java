package LeetCode0568_MaximumVacationDays;

import java.util.Arrays;

public class MaximumVacationDays {
	public int maxVacationDays(int[][] flights, int[][] days) {
        /*
         * flights:
         *     0 1 2
         *  --------
         *  0 |0 1 1
         *  1 |1 0 1
         *  2 |1 1 0
         * 
         * days:
         *     0 1 2
         *  --------
         *  0 |1 3 1 
         *  1 |6 0 3
         *  2 |3 3 3
         *
         * city      
         *     0 1 2  (weeks)
         *  --------
         *  0 |1 4 7
         *  1 |6 9 12
         *  2 |3 6 9
         *
         */
        int w_l = days[0].length, c_n = flights.length, res = Integer.MIN_VALUE;
        int[][] dp = new int[c_n][w_l];     
        for (int i = 0; i < c_n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = days[0][0];
        for(int i = 1; i < c_n; i++) {
            if(flights[0][i] == 1) dp[i][0] = days[i][0];
        }
    
        for(int j = 1; j < w_l; j++) { // week
            for(int i = 0; i < c_n; i++) { // city
                for(int k = 0; k < c_n; k++) { // next city
                    if((dp[i][j - 1] != -1) && (flights[i][k] > 0 || k == i)) {
                        dp[k][j] = Math.max(dp[k][j], dp[i][j - 1] + days[k][j]);
                        if(j == w_l - 1) res = Math.max(res, dp[k][j]);
                    }
                }
            }
        }
        //for(int[] row : dp) System.out.println(Arrays.toString(row));
        return res;
     }
}
