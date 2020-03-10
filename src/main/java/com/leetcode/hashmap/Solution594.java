package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Set;

public class Solution594 {
    public int findLHS(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer x : keySet) {
            if (keySet.contains(x + 1)) {
                max = Math.max(max, map.get(x) + map.get(x + 1));
            }
        }
        return max;
    }
}
