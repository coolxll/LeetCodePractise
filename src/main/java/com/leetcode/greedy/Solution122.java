package com.leetcode.greedy;

public class Solution122 {
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length <= 1) return 0;
//        int minPrice = prices[0];
//        int profit = 0;
//        for(int i=1;i<prices.length;i++) {
//            //下跌前要卖出
//            if(prices[i] < prices[i-1]) {
//                profit += prices[i - 1] - minPrice;
//                minPrice = prices[i];
//            }
//            if(i == prices.length - 1) {
//                profit += Math.max(prices[i] - minPrice,0); //不小于0
//            }
//        }
//        return profit;
//    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
