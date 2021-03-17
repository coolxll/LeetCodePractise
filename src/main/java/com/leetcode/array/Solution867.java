package com.leetcode.array;

public class Solution867 {
    public int[][] transpose(int[][] A) {
        if(A == null) return null;
        int n = A.length;
        if(n == 0) return new int[0][0];
        int m = A[0].length;

        int[][] ret = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = A[j][i];
            }
        }

        return ret;
    }


}
