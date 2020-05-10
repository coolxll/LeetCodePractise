package com.leetcode.stacknqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n]; //Result
        Deque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!indexes.isEmpty() && temperatures[i] > temperatures[indexes.peekLast()]) {
                int preIndex = indexes.pollLast();
                dist[preIndex] = i - preIndex;
            }
            indexes.offer(i);
        }
        return dist;
    }
}
