package com.leetcode.dp;

//环拆解成队列
public class Solution213 {
    public int rob(int[] nums) {
        //可以进行分类讨论，偷了开头的和不偷开头的
        //与RobI的区别就是相互成环
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums,0, nums.length - 2),
                rob(nums, 1,nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        if(nums == null || nums.length == 0) return 0;
        if(start > nums.length || end < 0 ) return 0;
        int pre1 = 0,pre2 = 0; //不保存全dp数组
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1; //类似链表移动
            pre1 = cur;
        }
        return pre1;
    }
}
