package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class Solution28 {
    //先写个暴力解，有空优化KMP
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            char h = haystack.charAt(i);
            char n = needle.charAt(0);
            if (h == n) {
                int j = 1;
                boolean matched = true;
                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        matched = false;
                        break;
                    }
                    j++;
                }
                if(matched) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Test
    public void test() {
        int i = strStr("abababac", "bab");
        Assert.assertEquals(1,i);
    }

    @Test
    public void test1() {
        int i = strStr("mississippi","issip");
        Assert.assertEquals(4,i);
    }
}
