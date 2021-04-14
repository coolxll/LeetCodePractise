package com.leetcode.string;

import org.junit.Test;

public class Solution712 {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = 0;
                }else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + s2.charAt(j - 1);
                }else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + s1.charAt(i - 1);
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1),
                            dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        int deleteSum = minimumDeleteSum("sea", "eat");
        System.out.println(deleteSum);
    }

    @Test
    public void test1() {
        int deleteSum = minimumDeleteSum("delete", "leet");
        System.out.println(deleteSum);
    }
}
