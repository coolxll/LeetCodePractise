package com.leetcode.string;

public class Solution8 {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int sign = 1;
        char[] charArray = s.toCharArray();
        //先判断正负号
        char c = charArray[0];
        int idx = 0;
        if(c == '-') {
            sign = -1;
            idx++;
        } else if(c == '+') {
            sign = 1;
            idx++;
        }
        long sum = 0;
        for (int i = idx; i < charArray.length; i++) {
            c = charArray[i];
            if(!Character.isDigit(c)) {
                return (int) (sum * sign);
            }
            sum = sum * 10 + c - '0';
            if(sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && sum * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (sign*sum);
    }
}
