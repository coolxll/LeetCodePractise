package com.leetcode.minihackthon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.leetcode.minihackthon.Main.innerLogic;

public class TestCase {

    @Test
    public void test() {
        List<String> input = Arrays.asList("1","2");
        String result = innerLogic(input);
        Assert.assertEquals("3",result);
    }
}
