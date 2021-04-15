package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution213_P {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int l = nums.length;
        int a = robHelper(Arrays.copyOfRange(nums,0,l-1));
        int b = robHelper(Arrays.copyOfRange(nums,1,l));
        return Math.max(a,b);
    }

    private int robHelper(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int l = nums.length;
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[l-1];
    }

    @Test
    public void test() {
        int rob = rob(new int[]{2, 3, 2});
        Assert.assertEquals(3,rob);
    }

    @Test
    public void test1() {
        int rob = rob(new int[]{1});
        Assert.assertEquals(1,rob);
    }

    @Test
    public void test2() {
        int rob = rob(new int[]{});
        Assert.assertEquals(1,rob);
    }
}
