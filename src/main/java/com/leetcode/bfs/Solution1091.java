package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //分析1： 如果首尾是1，则必然没有可能路径
        int n = grid.length;
        //非正方形，其实按照需求来说可以无需判断
        if (grid[0].length != n) return -1;
        //Fast Fail, 左上角或者右下角直接是1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n <= 2) return n;
        //定义八个方向
        int[][] directions = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int res = 1; //结果
        while (q.size() > 0) {
            int size = q.size();
            for (int i = size; i > 0; i--) { //涉及到什么时候res++，一层一层加
                int[] point = q.poll();
                for (int[] direction : directions) {
                    int row = point[0] + direction[0];
                    int col = point[1] + direction[1];
                    //没有访问过，且没有越界
                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0 && !visited[row][col]) {
                        if (row == n - 1 && col == n - 1) return res + 1;
                        visited[row][col] = true;
                        q.offer(new int[]{row, col}); //避免重复访问
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
