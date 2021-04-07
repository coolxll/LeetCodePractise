package com.leetcode.binarysearch;

/**
 * Created by Conan on 2017/2/12.
 */

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return  false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0, y= cols - 1;
        int middle;
        while(x < rows && y >= 0) {
            middle = matrix[x][y];
            if(middle < target) {
                x++;
            } else if(middle > target) {
                y--;
            } else {
                return true;
            }
        }
        return false;
    }
}
