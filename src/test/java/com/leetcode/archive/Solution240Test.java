package com.leetcode.archive;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conan on 2017/2/12.
 */
public class Solution240Test {
    @Test
    public void searchMatrix() throws Exception {
        int[][] matrix = new int[][] {
                new int[] {1,   4,  7, 11, 15},
                new int[] {2,   5,  8, 12, 19},
                new int[] {3,   6,  9, 16, 22},
                new int[] {10, 13, 14, 17, 24},
                new int[] {18, 21, 23, 26, 30}
        };

        boolean found = Solution240.searchMatrix(matrix, 17);
        Assert.assertTrue(found);
    }

}