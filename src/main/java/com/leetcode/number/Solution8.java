package com.leetcode.number;

import org.junit.Assert;
import org.junit.Test;

public class Solution8 {
    public int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        int n = chars.length;
        if (n == 0) {
            return 0;
        }
        char firstChar = chars[0];
        boolean skipFirst = false;
        if (firstChar == '-' || firstChar == '+') {
            skipFirst = true;
            if (n == 1) {
                return 0;
            }
            firstChar = chars[1];
        }
        if (!Character.isDigit(firstChar)) {
            return 0;
        }
        int sign = chars[0] == '-' ? -1 : 1;
        long num = 0;
        for (int i = skipFirst ? 1 : 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!Character.isDigit(ch)) break;
            int digit = ch - '0';
            //检查越界
            if (sign == 1 && num * 10 + digit > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && num * 10 + digit - 1 > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            num = num * 10 + digit;
        }
        num *= sign;
        return (int) num;
    }

    @Test
    public void test() {
        int i = myAtoi("42");
        Assert.assertEquals("simpleest", 42, i);
    }

    @Test
    public void test1() {
        int i = myAtoi("                    -42");
        Assert.assertEquals(-42, i);
    }

    @Test
    public void test2() {
        int i = myAtoi("+1");
        Assert.assertEquals(1, i);
    }

}


