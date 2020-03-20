package com.leetcode.string;

import javafx.util.Pair;

import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
    public String frequencySort(String s) {
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c]++;
        }
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                pq.offer(new Pair<>((char) i, freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair<Character, Integer> poll = pq.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }
        return sb.toString();
    }
}
