package com.leetcode.minih;


import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content;
        int sum = 0;
        List<String> lines = new ArrayList<>();
        while((content = br.readLine()) != null) {
            lines.add(content);
        }
        String output = innerLogic(lines);
        System.out.println(output);
    }

    private static String innerLogic(List<String> lines) {
        int result = 0;
        for(String line:lines) {
            if("".equals(line)) continue;
            else {
                result += Integer.parseInt(line);
            }
        }
        return String.valueOf(result);
    }

    @Test
    public void test() {
        List<String> input = Arrays.asList("1","2");
        String result = innerLogic(input);
        Assert.assertEquals("3",result);
    }

}
