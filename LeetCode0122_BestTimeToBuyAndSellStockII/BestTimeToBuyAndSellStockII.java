package LeetCode0122_BestTimeToBuyAndSellStockII;

public class BestTimeToBuyAndSellStockII {
	// solution 1: Simple One Pass
    /*
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i - 1] > 0) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }*/
    // solution 2: Peak Valley Approach
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}