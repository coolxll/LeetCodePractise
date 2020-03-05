package com.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution64Test {

    @Test
    public void minPathSum() {
        Solution64 solution64 = new Solution64();
        int[][] path = new int[][] {
                new int[] {1,3,1},
                new int[] {1,5,1},
                new int[] {4,2,1},
        };
        int minPathSum = solution64.minPathSum(path);
        System.out.println(minPathSum);
    }

    @Test
    public void minPathSum1() {
        Solution64 solution64 = new Solution64();
        int[][] path = new int[][] {
                new int[] {9,1,4,8},
        };
        int minPathSum = solution64.minPathSum(path);
        System.out.println(minPathSum);
    }
}