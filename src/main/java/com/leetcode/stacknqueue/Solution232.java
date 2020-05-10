package com.leetcode.stacknqueue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 */
public class Solution232 {


    class MyQueue {

        private Stack<Integer> s1;
        private Stack<Integer>  s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(!s2.empty()) {
                return s2.pop();
            } else {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
                int result = s2.pop();
                return result;
            }
        }

        /** Get the front element. */
        public int peek() {
            if(!s2.empty()) {
                return s2.peek();
            } else {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
                int result = s2.peek();
                return result;
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }

}
