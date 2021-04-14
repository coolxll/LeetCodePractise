package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class Solution44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //boolean数组默认值是false
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = true;
            else break;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        boolean aa = isMatch("aa", "*");
        Assert.assertTrue(aa);
    }
}
