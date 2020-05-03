package com.leetcode.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution224 {
    public int calculate1(String s) {
        int number = 0;//记录左侧数字
        int sign = 1; //记录正负号
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for(char c:charArray) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if(c == '+') {
                sum += number * sign;
                number = 0;
                sign = 1;
            } else if(c == '-') {
                sum += number * sign;
                number = 0;
                sign = -1;
            } else if(c == '(') {
                stack.push(sum);
                stack.push(sign);
                number = 0;
                sign = 1;
                sum = 0;
            } else if(c == ')') {
                int beforeSign = stack.pop();
                int tempNum = stack.pop();
                sum += number * sign;
                sum *= beforeSign;
                sum += tempNum;
                number = 0;
                sign = 1;
            }
        }
        if(number > 0) {
            sum += number * sign;
        }
        return sum;
    }

    private int evalExpr(Stack s) {
        //TODO:
        int result = 0;
        if (!s.isEmpty()) {
            result = (int) s.pop();
        }

        while(!s.isEmpty() && !((char)s.peek() == ')')) {
            char sign = (char) s.pop();
            if (sign == '+') {
                result += (int)s.pop();
            } else {
                result -= (int)s.pop();
            }
        }
        return result;
    }

    public int calculate(String s) {
        int operand = 0;
        int n = 0;
        Stack stack = new Stack();
        //逆序迭代
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //in reverse order
                //e.g. if 123 读取顺序是先读到3 再2 再1
                operand = (int) (Math.pow(10,n)*toNumber(c) + operand);
                n++;
            } else if(c != ' ') { //三种type number operator 和 括号
                if(n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }
                if (c == '(') {
                    int result = evalExpr(stack);
                    stack.pop();
                    stack.push(result);
                } else {
                    stack.push(c);
                }
            }
        }
        if (n != 0) {
            stack.push(operand);
        }
        return evalExpr(stack);
    }

    private int toNumber(char c) {
        return c - '0';
    }

    @Test
    public void testCalc() {
        int calculate = calculate("1 + 1");
        Assert.assertEquals(2,calculate);
    }

    @Test
    public void testCalc1() {
        int calculate = calculate("2-1 + 2 ");
        Assert.assertEquals(3,calculate);
    }

    @Test
    public void testCalc2() {
        int calculate = calculate("(1+(4+5+2)-3)+(6+8)");
        Assert.assertEquals(23,calculate);
    }

    @Test
    public void testCalc3() {
        int calculate = calculate("1-(5)");
        Assert.assertEquals(-4,calculate);
    }
}
