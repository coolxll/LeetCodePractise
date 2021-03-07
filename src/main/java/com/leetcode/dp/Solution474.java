package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //背包问题
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            int zeros = 0, ones = 0;
            for (char c : charArray) {
                if( c == '0') zeros++;
                else ones++;
            }
            //不复制的话 会受影响
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        int maxForm = findMaxForm(new String[]{"0"}, 1, 1);
        System.out.println(maxForm);
    }

    @Test
    public void test1() {
        int maxForm = findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        Assert.assertEquals(4,maxForm);
    }
}
