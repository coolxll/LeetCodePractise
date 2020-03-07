package com.leetcode.number;

import org.junit.Test;

public class Solution4Test {

    Solution4 solution4 = new Solution4();

    @Test
    public void findMedianSortedArrays() {
        int[] a = new int[] {1,3};
        int[] b = new int[] {2};
        double medianSortedArrays = solution4.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    @Test
    public void findMedianSortedArrays1() {
        int[] a = new int[] {1,3};
        int[] b = new int[] {2,4};
        double medianSortedArrays = solution4.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    @Test
    public void findMedianSortedArrays2() {
        int[] a = new int[] {1,2,3,4};
        int[] b = new int[] {7};
        double medianSortedArrays = solution4.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    @Test
    public void findMedianSortedArrays3() {
        int[] a = new int[] {1,2,3,4};
        int[] b = new int[] {3};
        double medianSortedArrays = solution4.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    @Test
    public void findMedianSortedArrays4() {
        int[] a = new int[] {};
        int[] b = new int[] {7,8,9};
        double medianSortedArrays = solution4.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }
}