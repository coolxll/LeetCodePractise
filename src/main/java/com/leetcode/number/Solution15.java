package com.leetcode.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Triple Sum 3Sum
    第一题TwoSum 的进阶版
  */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) return res;
        if (nums[n - 3] + nums[n - 2] + nums[n - 1] < 0) return res; //fast fail
        if (nums[0] + nums[1] + nums[2] > 0) return res;
        for (int i = 0; i < n - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int result = nums[i] + nums[l] + nums[r];
                if (result == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l = moveForward(nums, l);
                    r = moveBackward(nums, r);
                } else if (result > 0) {
                    r = moveBackward(nums, r);
                } else { //result < 0
                    l = moveForward(nums, l);
                }
            }
        }
        return res;
    }

    private int moveBackward(int[] nums, int r) {
        do {
            r--;
        } while (nums[r] == nums[r + 1] && r > 0); //跳过相同的
        return r;
    }

    private int moveForward(int[] nums,int l) {
        do {
            l++;
        } while(nums[l]==nums[l-1] && l < nums.length - 1); //跳过相同的
        return l;
    }


    @Test
    public void test() {
        List<List<Integer>> lists = threeSum(new int[]{0, 0, 0, 0});
        Assert.assertEquals(1, lists.size());
    }

    @Test
    public void test1() {
        List<List<Integer>> lists = threeSum(new int[]{-2,0,0,2,2});
        Assert.assertEquals(1, lists.size());
    }

    @Test
    public void test2() {
        List<List<Integer>> lists = threeSum(new int[]{0,0,0});
        Assert.assertEquals(1, lists.size());
    }
}
