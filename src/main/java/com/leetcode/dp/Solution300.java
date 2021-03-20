package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
