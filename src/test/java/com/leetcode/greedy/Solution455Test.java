package com.leetcode.greedy;

import org.junit.Test;

public class Solution455Test {

    @Test
    public void findContentChildren() {
        Solution455 solution455 = new Solution455();
        int[] g = new int[] {1,2,3};
        int[] s = new int[]{1, 1};
        int contentChildren = solution455.findContentChildren(g, s);
        assert contentChildren == 1;
    }
}