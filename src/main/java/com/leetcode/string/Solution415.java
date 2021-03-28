package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        char[] charArray1 = num1.toCharArray();
        char[] charArray2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int l1 = charArray1.length,l2= charArray2.length;
        int carry = 0;
        while(l1 > 0 || l2 > 0) {
            int x = l1 > 0 ? charArray1[--l1] - '0' : 0;
            int y = l2 > 0 ? charArray2[--l2] - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.insert(0,(char) (sum % 10 + '0'));
        }
        if(carry > 0) sb.insert(0,(char) (carry + '0'));
        return sb.toString();
    }

    @Test
    public void test() {
        String s = addStrings("1", "99");
        Assert.assertEquals(s,"100");
    }
}
