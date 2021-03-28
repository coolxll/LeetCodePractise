package com.leetcode.heap;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.PriorityQueue;

public class SolutionOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if(length < k) return arr;
        else {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k,(o1, o2) -> o2-o1);

            for (int i = 0; i < arr.length; i++) {
                if(pq.size() < k) {
                    pq.offer(arr[i]);
                } else {
                    if(arr[i] < pq.peek()) {
                        pq.poll();
                        pq.offer(arr[i]);
                    }
                }
            }
            int[] res =  new int[k];
            int i = 0;
            while(!pq.isEmpty()) {
                res[i++] = pq.poll();
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] leastNumbers = getLeastNumbers(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println(JSON.toJSONString(leastNumbers));
    }

    @Test
    public void test1() {
        int[] leastNumbers = getLeastNumbers(new int[]{0,1,2,1}, 1);
        System.out.println(JSON.toJSONString(leastNumbers));
    }
}
