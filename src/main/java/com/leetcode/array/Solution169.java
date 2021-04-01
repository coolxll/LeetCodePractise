package com.leetcode.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class Solution169 {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            int freq = freqMap.getOrDefault(nums[i],0);
            freqMap.put(nums[i],++freq);
        }

        Iterator<Map.Entry<Integer, Integer>> entryIterator = freqMap.entrySet().iterator();
        while(entryIterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = entryIterator.next();
            if(entry.getValue() > n/2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int majorityElement = majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        log.info("{}",majorityElement);
    }
}
