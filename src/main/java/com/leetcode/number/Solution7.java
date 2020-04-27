package com.leetcode.number;

import java.util.LinkedList;
import java.util.Queue;

public class Solution7 {
    //其实可以不用队列
    public int reverse(int x) {
        boolean negative = x < 0;
        if(x == Integer.MIN_VALUE) return 0; //负数范围比正数多1
        if(negative) x *= -1;
        Queue<Integer> queue = new LinkedList<>();
        int r = x % 10;
        queue.add(r);
        while (x / 10 > 0) {
            x = x / 10;
            r = x % 10;
            queue.add(r);
        }
        int result = 0;
        while(!queue.isEmpty()) {
            if(result  > Integer.MAX_VALUE / 10) {
                return  0;
            }
            result *= 10;
            result += queue.poll();
        }
        result = negative ? -1 * result : result;
        return  result;
    }
}
