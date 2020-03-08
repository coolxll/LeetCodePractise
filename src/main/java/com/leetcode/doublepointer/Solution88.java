package com.leetcode.doublepointer;

import org.junit.Test;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (indexMerge >= 0) {
            if(index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if(index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
                continue;
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    @Test
    public void test() {
        merge(new int[]{1, 2, 3, 0, 0, 0},
                3,
                new int[]{2, 5, 6},
                3);
    }
}
