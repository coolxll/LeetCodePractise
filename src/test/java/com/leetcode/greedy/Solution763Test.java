package com.leetcode.greedy;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution763Test {

    @Test
    public void partitionLabels() {
        Solution763 solution763 = new Solution763();
        List<Integer> partitionLabels = solution763.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(partitionLabels.toString());
    }
}