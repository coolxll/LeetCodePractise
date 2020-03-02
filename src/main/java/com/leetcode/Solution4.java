package com.leetcode;

/**
 * Binary Search 二分查找
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;

        //确保n1 < n2
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        //k是中位数的下标
        final int k = (n1 + n2 + 1) / 2; //整除 尾数舍去(第一个数组取几个，第二个数组取几个）

        //找出左中位数 和 右中位数
        int l = 0, r = n1; //定义两个左右循环的游标
        int m1 = 0, m2 =0;
        while (l < r) { //一定要满足的切分条件，第一个数组切哪里
            m1 = l + (r-l)/2;
            m2 = k - m1; //why, because all of the median only have k elements
            if(nums1[m1] < nums2[m2-1]) {  //右侧数组左中位数和左侧数组右中位数进行对比
                l = m1 + 1;
            } else {
                r = m1;
            }
        }
        m1 = l;
        m2 = k - l;

        System.out.println(String.format("m1:%d,m2:%d",m1,m2));

        int leftc1,leftc2,rightc1,rightc2;
        leftc1 = m1 - 1 < 0 ? Integer.MIN_VALUE : nums1[m1 - 1];
        rightc1 = m2 - 1 < 0 ? Integer.MIN_VALUE : nums2[m2 - 1];
        int c1 = Math.max(leftc1,rightc1);
        leftc2 = m1 >= n1? Integer.MAX_VALUE : nums1[m1];
        rightc2 = m2 >= n2? Integer.MAX_VALUE : nums2[m2];
        int c2 = Math.min(leftc2, rightc2);
        if((n1 + n2) % 2 == 1) {
            return c1;
        }

        return (c1+c2)*0.5;
    }
}
