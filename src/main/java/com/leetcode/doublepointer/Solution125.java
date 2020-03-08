package com.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class Solution125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            //只考虑字母和数字
            char ci = chars[i];
            char cj = chars[j];
            if (!Character.isDigit(ci) && !Character.isAlphabetic(ci)) {
                i++;
                continue;
            }
            if (!Character.isDigit(cj) && !Character.isAlphabetic(cj)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(ci) != Character.toLowerCase(cj)) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(isPalindrome("race a car"));
    }


}
