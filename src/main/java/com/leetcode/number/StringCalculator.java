package com.leetcode.number;

import org.junit.Test;

import java.util.Stack;

/**
 * 1+2-3*(4-5)
 *
 * digit: 0-9
 *
 * op: + - * /  ()个位数、表达式永远合法、没有特殊情况
 */
public class StringCalculator {
    char[] opArray = new char[] {'+','-','*','/','(',')'};
    Stack<Double> numStack = new Stack();
    Stack<Character> opStack = new Stack<>();
    // 1+2*3-3*4-5

    @Test
    public void test() {
        double calc = calc("1+2*3-4");
        System.out.println(calc);
    }

    public double calc(String input) {
        char[] charArray = input.toCharArray();
        for(int i=0;i<charArray.length;i++) {
            char c = charArray[i];
            if(isNumber(c)) {
                numStack.push((double) (c - '0'));
            }else {
                switch (c) {
                    case '+': {
                        if(i+2 > charArray.length || (charArray[i+2] != '*' && charArray[i+2] != '/')) {
                            double left = numStack.pop();
                            int right = charArray[++i] - '0'; //++i < num.length
                            numStack.push(left + right);
                            break;
                        } else {
                            opStack.push(charArray[i]);
                            numStack.push((double) (charArray[++i] - '0'));
                        }
                    }
                    case '-': {
                        if(i+2 > charArray.length || (charArray[i+2] != '*' && charArray[i+2] != '/')) {
                            double left = numStack.pop();
                            int right = charArray[++i] - '0'; //++i < num.length
                            numStack.push(left - right);
                            break;
                        } else {
                            opStack.push(charArray[i]);
                            numStack.push((double) (charArray[++i] - '0'));
                        }
                    }
                    case '*': {
                        double left = numStack.pop();
                        int right = charArray[++i] - '0'; //++i < num.length
                        numStack.push(left * right);
                        break;
                    }
                    case '/': {
                        double left = numStack.pop();
                        int right = charArray[++i] - '0'; //++i < num.length
                        numStack.push(left / right);
                        break;
                    }
                    case '(': {
                        int begin = i;
                        int cnt = 0;
                        while(charArray[i] != ')' && cnt == 0) { //(())
                            if(charArray[i] == '(') cnt++;
                            if(charArray[i] == ')') cnt++;
                            i++;
                        }
                        numStack.push(calc(input.substring(begin, i)));
                    }
                }
            }
        }
        return 0;
    }

    private boolean isOperator(char c) {
        return true;
    }


    private boolean isNumber(char c) {
        return c >= '0' || c <= '9';
    }

    private boolean isMultiplyOrDivide(char c) {
        return c == '*' || c == '/';
    }

}
