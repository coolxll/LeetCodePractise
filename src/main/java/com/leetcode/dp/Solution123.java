package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class Solution123 {

    public int maxProfit_brute (int[] prices) {
        // write code here
        if(prices == null || prices.length <= 1) return 0;
        int profit = maxProfitSection(prices,0,prices.length - 1);
        for (int i = prices.length - 1; i >= 1 ; i--) {
            if(prices[i] < prices[i - 1]) {
                //剪枝
                int j = i - 1;
                while(j >= 1 && prices[j] < prices[j-1]) {
                    j--;
                }
                int currProfit = maxProfitSection(prices, 0 ,j) + maxProfitSection(prices, i, prices.length-1);
                profit = Math.max(profit, currProfit);
                i = j;
            }
        }
        return profit;
    }

    //提高计算速度
    public int maxProfitSection(int[] prices,int start,int end) {
        //善用Max 和 min
        if(prices == null || end - start < 1) return 0;
        int minPrice = prices[start];
        int profit = 0;
        for(int i=start;i<=end;i++) {
            int price = prices[i];
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }


    //换个思路解决问题
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2= -prices[0], sell2 = 0;
        for (int i = 0; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }

    @Test
    public void test() {
        int[] input = new int[] {1,2,3};
        Assert.assertEquals(maxProfit_brute(input),2);

    }
}
