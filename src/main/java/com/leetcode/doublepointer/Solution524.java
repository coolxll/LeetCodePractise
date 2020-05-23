package com.leetcode.doublepointer;

import java.util.List;

public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String target : dictionary) {
            int l1 = result.length();
            int l2 = target.length();
            //已有的最长单词更长，或者长度一样的情况下，字典序在更前面
            //也是一种fail fast的策略
            if(l1 > l2 || (l1 == l2 && result.compareTo(target) < 0)) {
                //No Need to check since it can not be the longest word
                continue;
            }
            if (isSubstr(s, target)) {
                result = target;
            }
        }
        return result;
    }

    //核心逻辑
    private boolean isSubstr(String str, String subStr) {
        int i = 0, j = 0;
        while (i < str.length() && j < subStr.length()) {
            if(str.charAt(i) == subStr.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == subStr.length();
    }
}
