package com.leetcode.array;


import org.junit.Test;

//接雨水
public class Solution42 {

    private int[] ldp;
    private int[] rdp;

    //先暴力求解
    //优化成dp
    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int ans = 0;
        ldp = new int[height.length];
        rdp = new int[height.length];
        fillDpArray(height);
        for (int i = 0; i < height.length; i++) {
            //最左边和最右边都会漏掉
            int l = findLeftMax(height,i);
            int r = findRightMax(height,i);
            ans += Math.min(l,r) - height[i];
        }
        return ans;
    }

    private void fillDpArray(int[] height) {
        ldp[0] = height[0];
        int length = height.length;
        for (int i = 1; i < length; i++) {
            ldp[i] = Math.max(height[i], ldp[i - 1]);
        }
        rdp[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0 ; i--) {
            rdp[i] = Math.max(height[i], rdp[i + 1]);
        }
    }

    private int findRightMax(int[] height, int i) {
        return rdp[i];
    }

    private int findLeftMax(int[] height, int i) {
        return ldp[i];
    }

    @Test
    public void test() {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
}
