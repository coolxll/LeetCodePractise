package com.leetcode.greedy;

public class Solution121 {
    public int maxProfit(int[] prices) {
        //善用Max 和 min
        if(prices == null || prices.length <= 1) return 0;
        int minPrice = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            int price = prices[i];
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int buy1 = -prices[0],sell1 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(-prices[i], buy1);
            sell1 = Math.max(sell1, prices[i] + buy1);
        }
        return sell1;
    }
}
