package com.leetcode.dp;



public class Solution152 {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        int ans = nums[0];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxdp[i] = Math.max(maxdp[i-1] * nums[i], Math.max(nums[i],mindp[i-1] * nums[i]));  //三者取大的，maxdp[i-1]*nums[i],nums[i],
            mindp[i] = Math.min(mindp[i - 1] * nums[i], Math.min(nums[i], maxdp[i - 1] * nums[i]));
            ans = Math.max(ans, maxdp[i]);
        }
        return ans;
    }
}
