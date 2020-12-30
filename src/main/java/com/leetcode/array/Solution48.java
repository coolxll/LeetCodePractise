package com.leetcode.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        int m = matrix[0].length;
        //transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //原地翻转only works m=n
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }


    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }
}
