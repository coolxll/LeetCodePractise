package com.leetcode.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class RemoveDuplicates {
    //constraint: o(1) extra space
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        int lastNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != lastNum || index == 0) {
                nums[index++] = nums[i];
            }
            lastNum = nums[i];
        }
        return index;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2};
        int i = removeDuplicates(arr);
        System.out.println(JSON.toJSON(arr));
    }
}
