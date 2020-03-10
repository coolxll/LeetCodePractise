package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class Solution680 {
    public boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return isPalidrome(s,i+1,j) ||
                        isPalidrome(s, i, j-1);
            }
            i++;j--;
        }
        return true;
    }

    private boolean isPalidrome(String s,int begin, int end) {
        char[] charArray = s.toCharArray();
        int i = begin, j = end;
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;j--;
        }
        return true;
    }

    @Test
    public void test() {
        boolean abca = validPalindrome("abc");
        Assert.assertFalse(abca);
    }

    @Test
    public void test1() {
        boolean abca = validPalindrome("deeee");
        Assert.assertTrue(abca);
    }
}
