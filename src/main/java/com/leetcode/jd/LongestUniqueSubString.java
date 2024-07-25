package com.leetcode.jd;

public class LongestUniqueSubString {

    // 给定一个字符串最长无重复的字串
    // abcab 返回 abc
    // abcda 返回 abcd

    public static String longestUniqueSubString(String str) {
        int[] lastIndex = new int[256];
        for (int i = 0; i < lastIndex.length; i++) {
            lastIndex[i] = -1;
        }
        int start = 0;
        int maxLength = 0;
        int maxStart = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int last = lastIndex[c];
            if (last!= -1 && last >= start) {
                if (i - start > maxLength) {
                    maxLength = i - start;
                    maxStart = start;
                }
                start = last + 1;
            }
            lastIndex[c] = i;
        }
        return str.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String str = "abcda";
        System.out.println(longestUniqueSubString(str));
    }
}
