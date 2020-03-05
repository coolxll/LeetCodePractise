package com.leetcode.dp;

public class Solution303 {
    class NumArray {
        private int[] nums;
        private int[] sums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sums[i] = nums[i] + (i - 1 >= 0 ? sums[i - 1] : 0);
            }
        }

        public int sumRange(int i, int j) {
            return sums[j] - (i - 1 >= 0 ? sums[i - 1] : 0);
        }
    }
}
