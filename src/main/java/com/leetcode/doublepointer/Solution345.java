package com.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution345 {
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        Deque<Integer> positions = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ch = Character.toLowerCase(ch);
            if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
                positions.add(i);
            }
        }

        while(positions.size() > 1) {
            Integer i = positions.poll(),j = positions.pollLast();
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return String.valueOf(charArray);
    }

    @Test
    public void test() {
        String hello = reverseVowels("hello");
        Assert.assertEquals("holle",hello);
    }

    @Test
    public void test1() {
        String hello = reverseVowels("leetcode");
        Assert.assertEquals("leotcede",hello);
    }

    @Test
    public void test2() {
        String hello = reverseVowels("ha");
        Assert.assertEquals("ha",hello);
    }
}
