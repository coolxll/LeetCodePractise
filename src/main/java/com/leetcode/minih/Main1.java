package com.leetcode.minih;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String radix = br.readLine();
        String num1 = br.readLine();
        String num2 = br.readLine();
        String output = sumCalc(radix, num1, num2);
        System.out.println(output);
    }

    private static String sumCalc(String radix, String num1, String num2) {
        int rad = Integer.valueOf(radix);
        Long aLong = Long.valueOf(num1, rad);
        Long aLong1 = Long.valueOf(num2, rad);
        Long sum = aLong + aLong1;
        return toRadixN(sum, rad);
    }

    public static String toRadixN(long num,int n) {
        String str= "";
        long remain;
        long div = num;
        while (div>0) {
            remain = div % n;
            div = div/n;
            // 10-15 -> a-f
            if(remain>9) {
                str =(char)('A'+(remain-10)) + str;
            }else {
                str = remain+str;
            }
        }
        return str;
    }

    @Test
    public void test() {
        String calc = sumCalc("16", "A", "5");
        Assert.assertEquals("F", calc);
    }

}
