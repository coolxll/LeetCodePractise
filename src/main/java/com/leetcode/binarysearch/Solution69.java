package com.leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class Solution69 {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int l = 0, r = x;
        int guess = 0;
        do {
            int tryGuess = l + (r - l) / 2;
            int remain = x / tryGuess;
            if(remain == tryGuess) {
                guess = tryGuess;
                break;
            } else if(remain < tryGuess) { //往小的移动
                r = l + (r - l) / 2;
            } else {
                l = l + (r - l) / 2;
                guess = tryGuess;
            }
        } while(r - l > 1);
        return guess;
    }

    @Test
    public void test() {
        Assert.assertEquals(2,mySqrt(5));
        Assert.assertEquals(3,mySqrt(10));
        Assert.assertEquals(3,mySqrt(11));
        Assert.assertEquals(4,mySqrt(17));
        Assert.assertEquals(4,mySqrt(24));
        Assert.assertEquals(6,mySqrt(37));
        Assert.assertEquals(5,mySqrt(35));
    }

    @Test
    public void test1() {
        Assert.assertEquals(46339,mySqrt(2147395599));
    }
}
