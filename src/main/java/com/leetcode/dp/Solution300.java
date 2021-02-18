package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int len = lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assert.assertEquals(4,len);
    }

    @Test
    public void test1() {
        int len = lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        Assert.assertEquals(6,len);
    }
}
