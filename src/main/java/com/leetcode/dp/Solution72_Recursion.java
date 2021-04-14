package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution72_Recursion {
    private int[][] dp;
    private int count = 0;

    public int minDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        dp = new int[x+1][y+1];
        for(int i=0;i<x+1;i++) {
            Arrays.fill(dp[i],-1);
        }
        return minDistanceHelper(word1,word2,x,y);

    }

    private int minDistanceHelper(String word1,String word2, int i, int j) {
        count++;
        if(i == 0) {
            dp[i][j] = j;
            return j;
        }
        if(j == 0) {
            dp[i][j] = i;
            return i;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int insert,delete,replace;
        insert = minDistanceHelper(word1,word2,i-1,j);
        delete = minDistanceHelper(word1,word2,i,j-1);
        replace = word1.charAt(i-1) == word2.charAt(j-1) ? minDistanceHelper(word1,word2,i-1,j-1) : minDistanceHelper(word1,word2,i-1,j-1) + 1;
        dp[i][j] = Math.min(insert+1,Math.min(delete+1,replace));
        return dp[i][j];
    }

    @Test
    public void test() {
        int editCost = minDistance("abc", "adc");
        Assert.assertEquals(editCost,1);
    }

    @Test
    public void test1() {
        int editCost = minDistance("horse", "ros");
        Assert.assertEquals(editCost,3);
    }

    @Test
    public void test2() {
        int editCost = minDistance("intention", "execution");
        Assert.assertEquals(editCost,5);
    }
}
