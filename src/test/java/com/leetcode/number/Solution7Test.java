package com.leetcode.number;

import org.junit.Assert;
import org.junit.Test;

public class Solution7Test {

    @Test
    public void reverse() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(0);
        Assert.assertEquals(0,reverse);
    }

    @Test
    public void reverse1() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(345);
        Assert.assertEquals(543,reverse);
    }

    @Test
    public void reverse2() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(-123);
        Assert.assertEquals(-321,reverse);
    }

    @Test
    public void reverse3() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(120);
        Assert.assertEquals(21,reverse);
    }

    @Test
    public void reverse4() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(1534236469);
        Assert.assertEquals(0,reverse);
    }

    @Test
    public void reverse5() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(-2147483648 + 1);
        Assert.assertEquals(0,reverse);
    }

    @Test
    public void reverse6() {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(Integer.MAX_VALUE);
        Assert.assertEquals(0,reverse);
    }
}