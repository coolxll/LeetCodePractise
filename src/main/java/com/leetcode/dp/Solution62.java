package com.leetcode.dp;

public class Solution62 {

//    private int[][] dp;
//
//    public int uniquePaths(int m, int n) {
//        dp = new int[m][n];
//        for(int[] a:dp) Arrays.fill(a,-1);
//        return up(m - 1, n - 1);
//    }
//
//    private int up(int m, int n) {
//        if(dp[m][n] != -1) {
//            return dp[m][n];
//        }
//        int sum = 1;
//        if(m > 0 && n > 0) sum = up(m -1, n) + up(m, n -1);
//        else if(m > 0) sum = up(m - 1, n);
//        else if(n > 0) sum = up(m, n - 1);
//        dp[m][n] = sum;
//        return sum;
//    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i]  = 1;//填充最左侧的
        for (int j = 0; j < m; j++) dp[j][0] = 1;//填充最上侧的
        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                dp[a][b] = dp[a - 1][b] + dp[a][b - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
