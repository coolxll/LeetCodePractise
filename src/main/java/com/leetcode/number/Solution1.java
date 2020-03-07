package com.leetcode.number;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap();
        for(int i=0;i<nums.length;i++) {
            int a = nums[i]; //加数
            int b = target - a; //被加数
            if(tempMap.containsKey(b)) {
                int j = tempMap.get(b);
                return new int[] {j,i};
            } else {
                tempMap.put(a, i);
            }
        }
        return new int[] {};
    }
}
