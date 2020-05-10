package com.leetcode.greedy;

import org.junit.Test;

public class Solution122Test {

    @Test
    public void maxProfit() {
        Solution122 solution122 = new Solution122();
        int profit = solution122.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit);
    }

    @Test
    public void maxProfit1() {
        Solution122 solution122 = new Solution122();
        int profit = solution122.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(profit);
    }
}