package com.leetcode.stacknqueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                deque.push(Integer.valueOf(token));
            } else {
                int num2 = deque.pop();
                int num1 = deque.pop();
                int res;
                switch (token) {
                    case "+":
                        res = num1 + num2;
                        deque.push(res);
                        break;
                    case "-":
                        res = num1 - num2;
                        deque.push(res);
                        break;
                    case "*":
                        res = num1 * num2;
                        deque.push(res);
                        break;
                    case "/":
                        res = num1 / num2;
                        deque.push(res);
                        break;
                }
            }
        }
        return deque.poll();
    }

    private boolean isOperator(String ch){
        if(ch == null || ch.length() != 1) return false;
        char c = ch.charAt(0);
        if (c == '+') return true;
        if (c == '-') return true;
        if (c == '*') return true;
        //noinspection RedundantIfStatement
        if (c == '/') return true;
        return false;
    }

    @Test
    public void test() {
        int i = evalRPN(new String[]{"2", "1", "+", "3", "*"});
        Assert.assertEquals(9, i);
    }

    @Test
    public void test1() {
        int i = evalRPN(new String[]{"4", "13", "5", "/", "+"});
        Assert.assertEquals(6, i);
    }

    @Test
    public void test2() {
        int i = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        Assert.assertEquals(22, i);
    }

    @Test
    public void test3() {
        int i = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        Assert.assertEquals(6/(12*(-11))*10+17+5,i);
    }
}
