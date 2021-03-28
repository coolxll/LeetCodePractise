package com.leetcode.heap;

import java.util.*;
import java.util.stream.Collectors;

public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freq++;
            freqMap.put(num, freq);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }


    //粗暴解法
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freq++;
            freqMap.put(num, freq);
        }
        List<Integer> result = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = freqMap.entrySet();
        Comparator<Map.Entry<String, Integer>> byFreq = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Comparator<Map.Entry<String, Integer>> byDict = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        List<Map.Entry<Integer, Integer>> collect = entries.stream()
                .sorted(((o1, o2) -> (o2.getValue().compareTo(o1.getValue())))).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            result.add(collect.get(i).getKey());
        }
        return result;
    }
}
