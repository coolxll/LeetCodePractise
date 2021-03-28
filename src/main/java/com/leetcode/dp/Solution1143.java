package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        int l1 = text1.length(),l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        //Is it necessary to init with 0?
//        for (int i = 0; i < l2; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 0; i < l1; i++) {
//            dp[i][0] = 0;
//        }
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                char c1 = text1.charAt(i),c2 = text2.charAt(j);
                if(c1 == c2) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[l1][l2];
    }

    @Test
    public void test() {
        int longestCommonSubsequence = longestCommonSubsequence("abcde", "acd");
        Assert.assertEquals(longestCommonSubsequence,3);
    }
}
