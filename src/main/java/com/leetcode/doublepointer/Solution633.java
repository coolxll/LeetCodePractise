package com.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class Solution633 {

    public boolean judgeSquareSum(int c) {
        if(c<0) return false;

        //pow(a,2) + pow(b,2)
        int sqrtc = (int) Math.sqrt(c);
        int i = 0; int j = sqrtc;
        int sum = (int) (Math.pow(i, 2) + Math.pow(j, 2));
        while (i <= j) {
            sum = (int) (Math.pow(i, 2) + Math.pow(j, 2));
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else if (sum > c) {
                j--;
            }
        }
        return false;
    }

    @Test
    public void test() {
        boolean b = judgeSquareSum(5);
        Assert.assertTrue(b);
    }
}
