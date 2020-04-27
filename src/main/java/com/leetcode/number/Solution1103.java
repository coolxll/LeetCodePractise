package com.leetcode.number;

public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int i = 0;
        while (candies > 0) {
            if (candies > i + 1) {
                result[i % num_people] += (i + 1);
                candies -= (i + 1);
            } else {
                result[i % num_people] += candies;
                candies = 0;
            }
            i++;
        }
        return result;
    }
}
