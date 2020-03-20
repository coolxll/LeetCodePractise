package com.leetcode.number;

public class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int maxarea = 0;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) //移动较短的那个
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
