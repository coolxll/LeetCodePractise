package com.leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            int n = m % 2 == 0 ? Math.min(m + 1, nums.length - 1) : Math.max(0, m - 1);
//            int n = m ^ 1; //XOR
            if (nums[m] == nums[n]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l = Math.min(l, nums.length - 1);
        return nums[l];
    }

    public int singleNonDuplicate1(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //To check which half is even, the single number must be in the odd half
            //true means the first half are even
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }


    public int singleNonDuplicate2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }


    @Test
    public void test() {
        int[] nums = new int[]{1};
        int singleNonDuplicate = singleNonDuplicate(nums);
        Assert.assertEquals(1, singleNonDuplicate);
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int singleNonDuplicate = singleNonDuplicate(nums);
        Assert.assertEquals(2, singleNonDuplicate);
    }
}
