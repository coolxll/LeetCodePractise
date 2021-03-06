package com.leetcode.stacknqueue;

import java.util.Stack;

public class Solution155 {
    class MinStack {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.isEmpty()) {
                stack2.push(x);
            } else {
                int cur = stack1.peek();
                stack2.push(Math.min(x, cur));
            }
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
