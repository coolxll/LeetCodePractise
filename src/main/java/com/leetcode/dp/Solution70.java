package com.leetcode.dp;

public class Solution70 {
    public int climbStairs(int n) {
        int pre1 = 1,pre2 = 1;
        if(n <= 2) return n;
        for (int i = 2; i <= n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
