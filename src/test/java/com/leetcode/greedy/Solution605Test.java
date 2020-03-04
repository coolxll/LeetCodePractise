package com.leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution605Test {

    @Test
    public void canPlaceFlowers() {
        Solution605 solution605 = new Solution605();
        int[] flowerbeds = new int[]{1, 0, 0, 0, 0, 1};
        boolean canPlaceFlowers = solution605.canPlaceFlowers(flowerbeds, 2);
        System.out.println(canPlaceFlowers);
    }

    @Test
    public void canPlaceFlowers2() {
        Solution605 solution605 = new Solution605();
        int[] flowerbeds = new int[]{1, 0, 0, 0, 1};
        boolean canPlaceFlowers = solution605.canPlaceFlowers(flowerbeds, 1);
        System.out.println(canPlaceFlowers);
        Assert.assertTrue(canPlaceFlowers);
    }

    @Test
    public void canPlaceFlowers1() {
        Solution605 solution605 = new Solution605();
        int[] flowerbeds = new int[]{0,0,1,0,1};
        boolean canPlaceFlowers = solution605.canPlaceFlowers(flowerbeds, 1);
        System.out.println(canPlaceFlowers);
    }
}