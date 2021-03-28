package com.leetcode.string;

public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 0; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)) index++;
        return str1.substring(0, index);
    }

    public String longestCommonPrefix1(String[] strs) { //纵向扫描 比横向扫描快一点点
        if(strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) { //分治法
        if(strs == null || strs.length == 0) return "";
        return longestCommonPrefixHelper(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefixHelper(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = start + (end - start) / 2;
        String lcpLeft = longestCommonPrefixHelper(strs, start, mid);
        String lcpRight = longestCommonPrefixHelper(strs, mid + 1, end);
        return commonPrefix(lcpLeft,lcpRight);
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if(lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    public String longestCommonPrefix3(String[] strs) { //二分查找
        if(strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        int low = 0, high = minLength;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
            while (low < high) {
                int mid = low + (high - low) / 2;
                if(isCommonPrefix(strs,mid)) {
                    low = mid;
                } else {
                    high  = mid - 1;
                }
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 0; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if(str0.charAt(j) != strs[i].charAt(j)) return false;
            }
        }
        return true;
    }


}
