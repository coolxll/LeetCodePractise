package com.leetcode.dp;

/**
 * rob I
 * <p>
 * easy
 */
public class Solution198 {
    /**
     * 解题思路 就两种情况
     * 要么1,3,5,7,9
     * 要么2,4,6,8,
     * <p>
     * 思路错 反例 2,1,1,2 可以抢2,2 最大4
     * <p>
     * 使用递归思路求解
     * <p>
     * rob(n) = Max(rob(n-2) + money[i], rob(n-1))
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int pre1 = 0,pre2 = 0; //不保存全dp数组
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1; //类似链表移动
            pre1 = cur;
        }
        return pre1;
    }
}
