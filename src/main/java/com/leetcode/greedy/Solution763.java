package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[128]; //直接按ascii存储
        int size = S.length();
        for(int i = 0; i< size; i++) {
            lastIndexOfChar[S.charAt(i)] = i; //O(n) 遍历 存储lastIndex
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < size) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < size && i <= lastIndex; i++) {
                int index = lastIndexOfChar[S.charAt(i)];
                lastIndex = Math.max(index, lastIndex);
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1; //要从结束之后的下一个开始
        }
        return partitions;
    }
}
