package com.leetcode.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution53Test {

    @Test
    public void maxSubArray() {
        Solution53 solution53 = new Solution53();
        int i = solution53.maxSubArray(new int[]{1, 2});
        System.out.println(i);
    }
}