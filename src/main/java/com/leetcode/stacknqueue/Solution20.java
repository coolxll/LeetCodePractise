package com.leetcode.stacknqueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution20 {

    //可以用个map辅助
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char e = stack.pop();
                    if (ch != getOpposite(e)) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    private char getOpposite(char c) {
        char res;
        switch (c) {
            case '(':
                res = ')';
                break;
            case '[':
                res = ']';
                break;
            case '{':
                res = '}';
                break;
            default:
                res = '\0';
        }
        return res;
    }

    @Test
    public void test() {
        boolean valid = isValid("()");
        Assert.assertTrue(valid);
    }

    @Test
    public void test1() {
        boolean valid = isValid("([)]");
        Assert.assertFalse(valid);
    }
}
