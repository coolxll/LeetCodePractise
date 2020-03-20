package com.leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = letters[0];
        if (result > target) return result;
        if (letters[letters.length - 1] < target) return result;
        int l = 0, r = letters.length - 1;
        while (l < r) {
            int guess = l + (r - l) / 2;
            if (letters[guess] > target) {
                r = guess;
            } else {
                l = guess + 1;
            }
        }
        result = letters[l % letters.length];
        return result;
    }

    @Test
    public void test() {
        char a = nextGreatestLetter(new char[]{'c', 'f', 'j', 'm', 's', 'y'}, 'l');
        Assert.assertEquals('m', a);
    }
}

