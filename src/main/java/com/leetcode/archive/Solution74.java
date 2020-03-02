package com.leetcode.archive;


/**
 * Created by Conan on 2017/2/12.
 */
public class Solution74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols - 1;

        while(left <= right) {
            int middle = left + (right - left)/ 2;
            //convert middle into row and col
            int x = middle / cols; //第几行
            int y = middle % cols; //第几列
            int middle_value = matrix[x][y];
            if (middle_value < target) {
                left = middle + 1;
            } else if (middle_value > target) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
