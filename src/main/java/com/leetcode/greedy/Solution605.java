package com.leetcode.greedy;

public class Solution605 {
    //特殊边界需要特殊处理
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //思路 求出flowerbed 中最多能中多少朵花，再判断n是否小于等于它
        int cnt = 0;
        for(int i=0;i<flowerbed.length/* cnt 终止条件可以加入*/;i++) {
            if(flowerbed[i] == 1) {
                continue; //只有连续空着的0 才能种花
            }
            else {
                int prev = i - 1 >= 0 ? flowerbed[i - 1] : 0;
                int next = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;
                if(prev == 0 && next == 0) {
                    cnt++;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= cnt;
    }
}
