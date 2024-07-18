package com.leetcode.jd;

import org.junit.Test;

import java.util.Stack;

public class SimpleCalc {

    // 评估给定的数学表达式字符串
    public int evaluateExpression(String str) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                int val = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    val = (val * 10) + (str.charAt(i) - '0');
                    i++;
                }
                values.push(val);
                i--; // 调整循环递增
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    applyOperator(values, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            applyOperator(values, operators);
        }

        return values.pop();
    }

    private void applyOperator(Stack<Integer> values, Stack<Character> operators) {
        int b = values.pop();
        int a = values.pop();
        char op = operators.pop();

        switch (op) {
            case '+':
                values.push(a + b);
                break;
            case '-':
                values.push(a - b);
                break;
            case '*':
                values.push(a * b);
                break;
            case '/':
                if (b == 0) throw new ArithmeticException("除以零");
                values.push(a / b);
                break;
        }
    }

    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    @Test
    public void testHere() {
        try {
            int result = evaluateExpression("1+2*3-4/2");
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
