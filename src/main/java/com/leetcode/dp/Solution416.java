package com.leetcode.dp;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //fast fail
        if (sum % 2 != 0) return false;

        sum = sum / 2;

        boolean[] dp = new boolean[sum+1];

        return false;
    }
}
