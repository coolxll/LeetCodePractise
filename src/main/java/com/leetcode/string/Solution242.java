package com.leetcode.string;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnts[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            cnts[c]--;
            if (cnts[c] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnts['a' + i] != 0) {
                return false;
            }
        }
        return true;
    }
}
