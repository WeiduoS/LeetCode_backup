package LeetCode0188_BestTimeToBuyAndSellStockIV;

public class BestTimeToBuyAndSellStockIV {

    // Memory Limit Exceeded
    /*
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) return 0; 
        //                /
        //                |    dp[i][j - 1]
        // dp[i][j] = max |
        //                |    prices[j] - prices[m] + dp[i - 1][m]
        //                \
        int[][] dp = new int[k + 1][prices.length];
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                for(int m = 0; m < j; m++) {
                    if(prices[m] < prices[j]) {
                        dp[i][j] = Math.max(prices[j] - prices[m] + dp[i - 1][m], dp[i][j]);
                    }
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        //for(int[] row : dp) System.out.println(Arrays.toString(row));
        return dp[dp.length - 1][dp[0].length - 1];
    }*/
    // Time Limit Exceeded
    /*
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) return 0; 
        
        int[] dp = new int[prices.length];
        int[] prev = new int[prices.length];
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j < dp.length; j++) {
                for(int m = 0; m < j; m++) {
                    if(prices[m] < prices[j]) {
                        dp[j] = Math.max(prices[j] - prices[m] + prev[m], dp[j]);
                    }
                }
                dp[j] = Math.max(dp[j - 1], dp[j]);
            }
            for(int s = 0; s < dp.length; s++) prev[s] = dp[s]; 
        }
        return dp[dp.length - 1];
    }*/
    
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0) return 0; 
        if(k >= prices.length / 2) return maxProfitExtend(prices);
        int[] dp = new int[prices.length];
        int[] prev = new int[prices.length];
        
        for(int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for(int j = 1; j < dp.length; j++) {
                dp[j] = Math.max(dp[j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, + prev[j] - prices[j]);
            }
            for(int j = 0; j < dp.length; j++) prev[j] = dp[j]; 
        }
        
        return dp[dp.length - 1];
    }
    
    private int maxProfitExtend(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
