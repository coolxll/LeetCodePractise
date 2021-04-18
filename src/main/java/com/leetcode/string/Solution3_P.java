package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Solution3_P {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        int l = 0, r = 0, max = 0;
        for (int i = 0; i < charArr.length; i++) {
            char ch = charArr[i];
            if (charMap.containsKey(ch)) {
                l = Math.max(l,charMap.get(ch) + 1);
            }
            charMap.put(ch, i);
            r = i;
            max = Math.max(max,r - l + 1);
        }
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void test1() {
        Assert.assertEquals(1,lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3,lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2,lengthOfLongestSubstring("abba"));
    }
}
