package com.leetcode.dp;

import java.util.Arrays;

/**
 * 二维动态规划
 */
public class Solution64 {
    //递归带存储
    private int[][] storage;
    //can only right or down
    // m * n
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = n > 0 ? grid[0].length: 0;
        if(n == 0 || m == 0) return 0;
        if(storage == null) {
            storage = new int[n][m];
            for(int[] i:storage) Arrays.fill(i,-1); //优化填充代码写法
        }
        //默认length都大于0了，因为0的情况上面已经处理
        return minPathSum(grid, n - 1, m - 1);
    }

    private int minPathSum(int[][] grid, int x, int y) {
        if(x == 0 && y == 0) return grid[0][0];
        int minSum;
        if(storage[x][y] != -1) {
            return storage[x][y];
        }
        if(x >= 1 && y >= 1) {
            minSum = Math.min(minPathSum(grid, x - 1, y),minPathSum(grid, x, y - 1));
        } else if (x >= 1) {
            minSum = minPathSum(grid, x - 1, y);
        } else if (y >= 1) {
            minSum = minPathSum(grid, x, y - 1);
        } else {
            minSum = 0;
        }
        storage[x][y] = grid[x][y] + minSum;
        return storage[x][y];
    }

    /*public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n]; //一行的长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //坐标 i，j
                if (j == 0) {
                    dp[j] = dp[j];        // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1];    // 只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }*/
}
