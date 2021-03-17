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


    public int maxProfit1 (int[] prices) {
        // write code here
        if(prices == null) return 0;
        int len = prices.length;
        int[] profit1 = new int[len];
        int[] profit2 = new int[len];
        int min = prices[0];
        int profit = 0;
        for(int i=0;i<len;i++) {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i] - min);
            profit1[i] = profit;
        }
        int max = prices[len-1];
        for(int j=len-1;j>0;j--) {
            max = Math.max(max,prices[j]);
            profit = max - prices[j];
            profit2[j] = profit;
        }
        for(int i=0;i<len;i++) {
            profit = Math.max(profit,profit1[i] + profit2[i]);
        }
        return profit;
    }




    @Test
    public void test() {
        int[] input = new int[] {1,2,3};
        Assert.assertEquals(maxProfit_brute(input),2);

    }

    @Test
    public void test1() {
        int[] input = new int[] {8,9,3,5,1,3};
        int profit = maxProfit1(input);
        Assert.assertEquals(4,profit);
    }

    @Test
    public void test2() {
        int[] input = new int[] {2,4,10,57,30,82,90,12,5,13};
        int profit = maxProfit1(input);
        Assert.assertEquals(115,profit);
    }
}

