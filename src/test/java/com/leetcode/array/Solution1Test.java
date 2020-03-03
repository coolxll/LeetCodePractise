package com.leetcode.array;

import com.leetcode.array.Solution1;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1Test {

    @Test
    public void twoSum() {
        Solution1 solution1 = new Solution1();
        int[] intArray = solution1.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(intArray,new int[] {0,1});
    }
}