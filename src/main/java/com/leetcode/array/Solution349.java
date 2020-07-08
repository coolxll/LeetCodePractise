package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2,nums1);
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        int l1 = set1.size();
        int l2 = set2.size();
        if(l1 <= l2) {
            return intersection(set1,set2);
        } else {
            return intersection(set2, set1);
        }

    }

    private int[] intersection(Set<Integer> set1,Set<Integer> set2) {
        set1.retainAll(set2);
        return set1.parallelStream().mapToInt(Integer::intValue).toArray();
    }
}
