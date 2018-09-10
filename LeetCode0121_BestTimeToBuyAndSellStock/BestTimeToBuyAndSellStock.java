package LeetCode0121_BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {
	/*
    public int maxProfit(int[] prices) {
        int[] beforeMin = new int[prices.length];
        for(int i = 0; i< beforeMin.length; i++) {
            beforeMin[i] = prices[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            beforeMin[i] = min;
        }       
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] - beforeMin[i] > profit) profit = prices[i] - beforeMin[i];
        }
        return profit;
    }*/
    
    /*
    public int maxProfit(int[] prices) {
        int[] dp  = new int[prices.length + 1];
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) min = prices[i];
            profit = Math.max(profit, prices[i] - min);
        }
        
        return profit;
    }*/
    
    // Kadane's Algorithm
    public int maxProfit(int[] prices) {
        int curSum = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            curSum += prices[i] - prices[i - 1];
            if(curSum <= 0) curSum = 0;    
            profit = Math.max(profit, curSum);
        }
        return profit;
    }
}