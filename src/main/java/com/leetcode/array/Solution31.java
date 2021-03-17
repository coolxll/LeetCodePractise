package com.leetcode.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int l = nums.length;
        //较小数 较大数
        int minimum = -1;
        int secondMinimum = -1;
        for (int i = l - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                minimum = i;
                break;
            }
        }
        //说明纯倒序
        if(minimum == -1) {
            reverse(nums,0,l-1);
            return;
        }
        for (int i = l - 1; i > 0; i--) {
            if(nums[i] > nums[minimum]) {
                secondMinimum = i;
                break;
            }
        }
        swap(nums, minimum, secondMinimum);
        reverse(nums,minimum+1,l-1);
    }

    private void swap(int[] nums, int a, int b) {
        int x = nums[a];
        nums[a] = nums[b];
        nums[b] = x;
    }


    //Reverse from index x
    private void reverse(int[] nums, int x, int y) {
        while (x < y) {
            swap(nums,x++,y--);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[]{2, 3, 1};
        //minimum should be 2
        //second minimum should be 0
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
