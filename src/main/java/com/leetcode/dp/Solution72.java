package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class Solution72 {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int op1 = Math.min(ic,dc);
        int op2 = Math.min(rc, ic+dc);
        return minDistance(str1,str2,op1,op2);
    }

    public int minDistance(String word1, String word2, int op1, int op2) {
        int x = word1.length();
        int y = word2.length();

        if(x == 0 || y == 0) {
            return Math.max(x,y);
        }

        int[][] dp = new int[x+1][y+1];

        //初始化边界状态
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = i * op1;
        }
        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = i * op1;
        }

        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                int left = dp[i-1][j] + op1;
                int down = dp[i][j-1] + op1;
                int left_down = dp[i-1][j-1];
                left_down = word1.charAt(i-1) == word2.charAt(j-1) ? left_down : left_down + op2;
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[x][y];

    }

    @Test
    public void test() {
        int editCost = minEditCost("abc", "adc", 5, 3, 2);
        Assert.assertEquals(editCost,2);
    }

}
