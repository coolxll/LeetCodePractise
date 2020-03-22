package com.leetcode.bfs;

public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //分析1. 如果首尾是1，则必然没有可能路径
        int n = grid.length;
        if (grid[0].length != n) return -1;
        //Fast Fail
        if (grid[0][0] == 1) return -1;
        return -1;
    }
}
