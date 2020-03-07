package com.leetcode.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class RotateStringByK {
    public String shift(String s, int k) {
        //shift right
        String s1 = s.substring(0, s.length() - k);
        String s2 = s.substring(s.length() - k, s.length());
        log.info("{},{}",s1,s2);
        return s2 + s1;
    }

    @Test
    public void test() {
        String shift = shift("abcd123", 2);
        System.out.println(shift);
    }
}
