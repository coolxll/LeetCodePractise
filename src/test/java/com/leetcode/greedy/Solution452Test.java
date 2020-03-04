package com.leetcode.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution452Test {

    @Test
    public void findMinArrowShots() {
        int[][] points = new int[][] {
                //[[10,16],[2,8],[1,6],[7,12]]
                new int[] {10,16},
                new int[] {2,8},
                new int[] {1,6},
                new int[] {7,12},
        };
        Solution452 solution452 = new Solution452();
        int minArrowShots = solution452.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}