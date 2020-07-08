package com.leetcode.array;

import org.junit.Test;

public class SingleNum {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n:nums) {
            result ^= n;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(0^4^2^4);
    }
}
