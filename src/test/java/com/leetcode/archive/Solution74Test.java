package com.leetcode.archive;

import com.leetcode.binarysearch.Solution74;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conan on 2017/2/12.
 */
public class Solution74Test {
    @Test
    public void searchMatrix() {
        int[][] matrix = new int[][] {
                new int[] {1,   3,  5,  7},
                new int[] {10, 11, 16, 20},
                new int[] {23, 30, 34, 50}
        };
        boolean found = Solution74.searchMatrix(matrix, 16);
        Assert.assertTrue(found);
    }

    @Test
    public void shifting() {
        int t = 1 << 5;
        System.out.println(t);
    }

}