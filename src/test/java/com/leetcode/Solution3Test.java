package com.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class Solution3Test {

    private Solution3 solution3  = new Solution3();;


    @Before
    public void reset() {
        solution3.reset();
    }

    @Test
    public void test1() {
        int abcabcbb = solution3.lengthOfLongestSubstring("abcabcbb");
        HashMap map = new HashMap<>();
        Assert.assertEquals(abcabcbb, 3);
        System.out.println(solution3.getCount());
    }

    @Test
    public void test2() {
        int bbbbb = solution3.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(bbbbb, 1);
        System.out.println(solution3.getCount());
    }

    @Test
    public void test3() {
        int pwwkew = solution3.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(pwwkew,3);
        System.out.println(solution3.getCount());
    }

    @Test
    public void test4() {
        int dvdf = solution3.lengthOfLongestSubstring("dvdf");
        Assert.assertEquals(dvdf,3);
        System.out.println(solution3.getCount());
    }

    @Test
    public void test5() {
        int dvdf = solution3.lengthOfLongestSubstring("abcabcdabfhua");
        Assert.assertEquals(dvdf,7);
    }

 
}