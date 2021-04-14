package com.leetcode.string;

import org.junit.Test;

public class Solution583 {

    public int minDistanceLCS(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence(word1, word2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        //Is it necessary to init with 0?
//        for (int i = 0; i < l2; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 0; i < l1; i++) {
//            dp[i][0] = 0;
//        }
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[l1][l2];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }else if (j == 0) {
                    dp[i][j] = i;
                }else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        System.out.println(minDistance("sea","eat"));
    }
}
