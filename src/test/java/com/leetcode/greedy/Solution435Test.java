package com.leetcode.greedy;

import org.junit.Test;

public class Solution435Test {

    @Test
    public void eraseOverlapIntervals() {
        Solution435 solution435 = new Solution435();
        int[][] intervals = new int[][] {
                new int[] {1,2},
                new int[] {2,3},
//                new int[] {1,2}
        };
        int i = solution435.eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

    @Test
    public void eraseOverlapIntervals1() {
        Solution435 solution435 = new Solution435();
        int[][] intervals = new int[][] {
                //[[1,100],[11,22],[1,11],[2,12]]
                new int[] {1,100},
                new int[] {11,22},
                new int[] {1,11},
                new int[] {2,12},
        };
        int i = solution435.eraseOverlapIntervals(intervals);
        System.out.println(i);
    }
}