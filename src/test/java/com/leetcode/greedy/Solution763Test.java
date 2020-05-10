package com.leetcode.greedy;

import org.junit.Test;

import java.util.List;

public class Solution763Test {

    @Test
    public void partitionLabels() {
        Solution763 solution763 = new Solution763();
        List<Integer> partitionLabels = solution763.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(partitionLabels.toString());
    }
}