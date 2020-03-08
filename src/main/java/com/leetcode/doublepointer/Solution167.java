package com.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if(sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            }
        }
        return new int[]{};
    }

    @Test
    public void test() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(new int[]{1, 2},ints);
    }
}
