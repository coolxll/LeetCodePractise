package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.max;


public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[] hold = new int[n+1];
        int[] sold = new int[n+1];
        int[] rest = new int[n+1];
        rest[0] = 0;
        sold[0] = 0;
        hold[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            hold[i] = max(hold[i-1],rest[i-1] - prices[i-1]); //继续Hold 或者买入
            sold[i] = hold[i-1] + prices[i-1]; //只有hold才能sell
            rest[i] = max(rest[i-1],sold[i-1]); //啥都不干
        }
        return max(rest[n],sold[n]);
    }

    @Test
    public void test() {
        int maxProfit = maxProfit(new int[]{1, 2, 3, 0, 2});
        Assert.assertEquals(3,maxProfit);
    }
}
