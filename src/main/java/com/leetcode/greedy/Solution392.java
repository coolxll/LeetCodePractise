package com.leetcode.greedy;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        int index = 0;
        for (char c : chars) {
            index = t.indexOf(c,index);
            if(index == -1) {
                return false;
            }
            index++;
        }
        return true;
    }
}
