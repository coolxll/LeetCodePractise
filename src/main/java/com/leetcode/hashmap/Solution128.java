package com.leetcode.hashmap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution128 {
    public int longestConsecutive1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                //下边界开始
                int length = 1;
                while(set.contains(++i)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        int max_length = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                length++;
            } else if (nums[i] == nums[i-1]) {

            } else {
                max_length = Math.max(length, max_length);
                length = 1;
            }
        }
        max_length = Math.max(length, max_length);
        return max_length;
    }

    //dp
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int num : nums) {
            if(dp.containsKey(num)) continue;
            int l = dp.getOrDefault(num - 1, 0);
            int r = dp.getOrDefault(num + 1, 0);
            if (l > 0 && r > 0) {
                dp.put(num, l + r + 1);
                dp.put(num - l, l + r + 1);
                dp.put(num + r, l + r + 1);
            } else if (l > 0) {
                dp.put(num, l + 1);
                dp.put(num - l, l + 1);
            } else if (r > 0) {
                dp.put(num, r + 1);
                dp.put(num + r, r + 1);
            } else {
                dp.put(num, 1);
            }
        }
        return dp.values().stream().max(Integer::compare).get();
    }



    @Test
    public void test() {
        int consecutive = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        Assert.assertEquals(4,consecutive);
    }

    @Test
    public void test1() {
        int consecutive = longestConsecutive(new int[]{0,-1});
        Assert.assertEquals(2,consecutive);
    }

    @Test
    public void test2() {
        int consecutive = longestConsecutive(new int[]{1,2,0,1});
        Assert.assertEquals(3,consecutive);
    }
}
