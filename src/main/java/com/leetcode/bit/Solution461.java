package com.leetcode.bit;

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance++;
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
