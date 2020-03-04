package com.leetcode.greedy;

public class Solution665 {
    //Non Decreasing 非递减
    public boolean checkPossibility(int[] nums) {
        int violate = 0;
        for(int i=0;i<nums.length - 1;i++) {
            //还要和i-1的元素比较
            if(nums[i] > nums[i + 1]) {
                violate++;
                if(i - 1 < 0 || nums[i+1] > nums[i-1]) { //i+1 要在数组范围内， i - 1 要大于0
                    nums[i] = nums[i + 1]; //Default操作，把后面的元素变小，影响面小
                } else { //边界情况
                    nums[i + 1] = nums[i]; //把当前元素变大
                }
            }
            if(violate > 1) {
                return false;
            }
        }
        return true;
    }

}
