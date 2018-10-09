package LeetCode0309_BestTimeToBuyAndSellStockWithCooldown;

public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] hold = new int[n];
        sell[0] = Integer.MIN_VALUE;
        buy[0] = -prices[0];
        for(int i = 1; i < n; i++) {
            
            buy[i] = Math.max(buy[i - 1], hold[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], sell[i - 1]);
        }
        //System.out.println(Arrays.toString(buy));
        //System.out.println(Arrays.toString(sell));
        //System.out.println(Arrays.toString(hold));
        return Math.max(sell[n - 1], hold[n - 1]);
    }
}