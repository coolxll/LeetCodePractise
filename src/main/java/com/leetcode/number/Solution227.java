package com.leetcode.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution227 { //这个算法比较慢，但能正确算出答案
    //顺带连括号也实现了就变成了 Solution772

    /*
     思路
     + - 普通入栈
     * / 入栈且计算
     */

    public int calculate(String expression) {
        Deque<Integer> s = new ArrayDeque();
        int num = 0;
        char sign = '+';  //相当于把表达式改成 0 + expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                //递归开始
                int j = i + 1;
                int cnt = 0;
                char c = expression.charAt(j);
                while (!(c == ')' && cnt == 0)) { //等价于 c!=')' || cnt != 0
                    if (c == '(') cnt++;
                    if (c == ')') cnt--;
                    c = expression.charAt(++j);
                }
                int result = calculate(expression.substring(i + 1, j));
                i = j;
                num = result;
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); //字符转数字
            }
            if (isOperator(ch) || i == expression.length() - 1) {//非数字且非空格或者走到最后
                switch (sign) {
                    case '+':
                        s.push(num);
                        break;
                    case '-':
                        s.push(-num);
                        break;
                    case '*':
                        int pre = s.pop();
                        s.push(pre * num);
                        break;
                    case '/':
                        pre = s.pop();
                        s.push(pre / num); //整除
                        break;
                }
                num = 0;
                sign = ch;
            }
        }
        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }

    private boolean isOperator(char ch){
        if (ch == '+') return true;
        if (ch == '-') return true;
        if (ch == '*') return true;
        if (ch == '/') return true;
        return false;
    }

    @Test
        public void test () {
            int calculate = calculate("3+2*2");
            Assert.assertEquals(7, calculate);
        }

        @Test
        public void test1 () {
            int calculate = calculate("3/2");
            Assert.assertEquals(1, calculate);
        }

        @Test
        public void test2 () {
            int calculate = calculate(" 3+ 5 / 2 ");
            Assert.assertEquals(5, calculate);
        }

        @Test
        public void test3 () {
            int calculate = calculate("( 3+ (5 / 2) )");
            Assert.assertEquals(5, calculate);
        }

        @Test
        public void test4 () {
            int calculate = calculate("2-(5-6)");
            Assert.assertEquals(3, calculate);
        }

        @Test
        public void test5 () {
            int calculate = calculate("2*(5+5*2)/3+(6/2+8)");
            Assert.assertEquals(21, calculate);
        }

        @Test
        public void test6 () {
            int calculate = calculate("4+(4*(3/3*(1+2)+2))");
            Assert.assertEquals(24, calculate);
        }

    }
