package com.leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution665Test {

    @Test
    public void checkPossibility() {
        Solution665 solution665 = new Solution665();
        boolean possibility = solution665.checkPossibility(new int[]{3, 4, 2, 3});
        Assert.assertFalse(possibility);
    }

    @Test
    public void checkPossibility1() {
        Solution665 solution665 = new Solution665();
        boolean possibility = solution665.checkPossibility(new int[]{4, 2, 3});
        Assert.assertTrue(possibility);
    }

    @Test
    public void checkPossibility2() {
        Solution665 solution665 = new Solution665();
        boolean possibility = solution665.checkPossibility(new int[]{3, 4, 2,6});
        System.out.println(possibility);
        Assert.assertTrue(possibility);
    }

    @Test
    public void checkPossibility3() {
        Solution665 solution665 = new Solution665();
        boolean possibility = solution665.checkPossibility(new int[]{-1, 4, 2,3});
        System.out.println(possibility);
        Assert.assertTrue(possibility);
    }
}