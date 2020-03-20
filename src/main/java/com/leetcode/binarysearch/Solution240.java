package com.leetcode.binarysearch;

/**
 * Created by Conan on 2017/2/12.
 */
public class Solution240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return  false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0, y= cols - 1;
        int middle = matrix[x][y];
        while(x < rows && y >= 0) {
            middle = matrix[x][y];
            if(middle < target) {
                x++;
            } else  if( middle > target) {
                y--;
            } else {
                return true;
            }
        }
        return false;
    }
}
