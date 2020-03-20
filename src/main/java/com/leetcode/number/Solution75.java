package com.leetcode.number;

import org.junit.Test;

import java.util.Arrays;

//三种元素 oN的排序
public class Solution75 {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i] - 0]++;
        }
        for (int i = 0, k=0; i < nums.length && k < 3;k++) {
            for (int j = 0; j < freq[k]; j++) {
                nums[i++] = k;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int head = 0,tail = nums.length - 1;
        int curr = 0;
        while (curr <= tail) {
            int curValue = nums[curr];
            if (curValue == 0) {
                swap(nums, head, curr);
                head++;
                curr++;
            } else if (curValue == 2) {
                swap(nums, tail, curr);
                tail--;
            } else {
                curr++;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[] {1,2,0};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[] {2,2,2};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
