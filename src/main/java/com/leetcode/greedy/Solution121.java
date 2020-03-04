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
}
