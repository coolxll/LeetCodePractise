package com.leetcode.stacknqueue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            int start = 0;
            for (int j = 0; j < n2; j++) {
                if(nums2[j] == nums1[i]) {
                    start = j;
                    break;
                }
            }
            for (int j = start; j < n2; j++) {
                if(nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    public int[] nextGreaterElements(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>(); //The Deque/Stack is used to store pre item
        HashMap<Integer,Integer> nextGreaterMap = new HashMap<>(); //The Map is used to save item and next greater item
        int[] res = new int[nums1.length];
        for (int value : nums2) {
            while (!stack.isEmpty() && value > stack.peek()) { //element > stack.peek
                nextGreaterMap.put(stack.pop(), value);
            }
            stack.push(value);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreaterMap.getOrDefault(nums1[i],-1);
        }
        return res;
    }

    @Test
    public void testDeque() {
        // Create ArrayDeque with three elements.
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(10);
        deque.push(500);
        deque.push(1000);

        // Peek to get the top item, but do not remove it.
        int peekResult = deque.peek();
        System.out.println(peekResult);

        // Call pop on the Deque.
        int popResult = deque.pop();
        System.out.println(popResult);

        // Pop again.
        popResult = deque.pop();
        System.out.println(popResult);
    }

}
