package com.leetcode.array;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class RotateArray {
    public void rotate(int[] nums, int k) {
        //考虑k>length的情况
        if(k > nums.length) {
            k = k % nums.length;
        }
        int l = nums.length - 1;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) { //5,6,7
            temp[i] = nums[l - k + 1 + i];
        }
        for (int i = l; i >= k; i--) { //last = nums[0]
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    //右移一位
    private void rotate(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        log.info(JSON.toJSONString(nums));
        rotate(nums,3);
        log.info(JSON.toJSONString(nums));
    }
}
