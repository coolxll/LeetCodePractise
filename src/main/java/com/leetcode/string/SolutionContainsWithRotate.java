package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class SolutionContainsWithRotate {
    /**
     * 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
     *
     * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
     * @param a
     * @param b
     * @return
     */
    public static boolean isContainsByConcat(String a, String b){
        String newaa = a.concat(a);
        return newaa.contains(b);
    }

    @Test
    public void test_isContainsByConcat() {
        boolean containsByConcat = isContainsByConcat("AABCD", "CDAA");
        Assert.assertTrue(containsByConcat);
    }

    public boolean judge (String str) {
        // write code here
        char[] charArray = str.toCharArray();
        int l=0,r=charArray.length-1;
        while(l<r) {
            l++;
            r--;
            if(charArray[l] != charArray[r]) return false;
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(judge("ababb"));
    }
}
