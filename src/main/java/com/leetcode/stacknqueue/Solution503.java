package com.leetcode.stacknqueue;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) { //2n + mod 解决循环数组的遍历问题
            int curnum = nums[i % n];
            while(!stack.isEmpty() && nums[stack.peek()] < curnum) {
                int preIndex = stack.pop();
                dist[preIndex] = curnum;
            }
            if(i < n) {
                stack.push(i);
            }
        }
        return dist;
    }

    @Test
    public void test() {
        int[] data = new int[]{1, 2, 1};
        int[] greaterElements = nextGreaterElements(data);
        System.out.println(JSON.toJSONString(greaterElements));
    }
}
