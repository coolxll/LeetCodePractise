package com.leetcode.minihackthon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public static String innerLogic(List<String> lines) {
        int result = 0;
        for(String line:lines) {
            if("".equals(line)) continue;
            else {
                result += Integer.parseInt(line);
            }
        }
        return String.valueOf(result);
    }
}
