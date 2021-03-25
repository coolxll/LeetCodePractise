package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionNumberOnce {


    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : array) {
            if(result.contains(i)) result.remove((Integer) i);
            else result.add(i);
        }
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int[] FindNumsAppearOnce1 (int[] array) {
        // write code here
        int x = Arrays.stream(array).reduce((x1, x2) -> (x1 ^ x2)).getAsInt(); //XOR result
        int l = x & -x;
        /*
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
         */

        int a = 0, b = 0;
        for (int n : array) {
            if ((l & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        if(a>b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        return new int[]{a, b};

    }
}
