package com.leetcode.dp;


import org.junit.Test;

//最长回文子串
public class Solution5 {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);
            if (s1.length() > result.length()) {
                result = s1;
            }
            if (s2.length() > result.length()) {
                result = s2;
            }
        }
        return result;
    }

    private String expand(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r >= l + 1 ? s.substring(l+1,r) : "";
    }

    @Test
    public void test() {
        String longestPalindrome = longestPalindrome("a");
        System.out.println(longestPalindrome);
    }

    @Test
    public void test1() {
        String longestPalindrome = longestPalindrome("babad");
        System.out.println(longestPalindrome);
    }

}

