package com.leetcode.number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while(x > 0) {
            int r = x % 10;
            list.add(r);
            x = x / 10;
        }
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test() {
        isPalindrome(121);
    }
}
