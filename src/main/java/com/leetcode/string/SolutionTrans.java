package com.leetcode.string;

import org.junit.Test;

public class SolutionTrans {

    public String trans(String str, int n) {
        // write code here
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(Character.isSpaceChar(c)) {
                result.append(sb.reverse());
                sb = new StringBuilder();
                result.append(c);
            } else {
                if(Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(Character.toUpperCase(c));
                }
            }
        }
        result.append(sb.reverse());
        return result.toString();
    }


    @Test
    public void test() {
        String aSample = trans("This is a sample", 16);
        System.out.println(aSample);
    }
}
