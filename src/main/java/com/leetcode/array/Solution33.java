package com.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class Solution33 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int l = 0, r = n - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) return m;
            if(nums[0] <= nums[m]) { //左边有序
                if(nums[0] <= target && target < nums[m]) { //0-m判断有序
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else { //右边有序
                if(nums[m] < target && target <= nums[n-1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int search = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
        Assert.assertEquals(6,search);
        search = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        Assert.assertEquals(4,search);
        search = search(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 8);
        Assert.assertEquals(4,search);
    }

}
