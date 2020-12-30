package com.leetcode.minihackthon;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    static class Solu {
        int valueFirst;
        int valueLast;

        public Solu() {
            this.valueFirst = 0;
            this.valueLast = 0;
        }
    }

    private static List<List<Solu>> dp = new ArrayList<>();

    private static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] redPackets = line.split(" ");
        int output = solution3(redPackets);
        System.out.println(output);
    }

    private static int solution3(String[] redPackets) {
        List<Integer> nums = new ArrayList<>();
        for (String res: redPackets) {
            int num = Integer.parseInt(res);
            nums.add(num);
        }
        for (int i = 0; i < nums.size(); i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < nums.size(); j ++) {
                dp.get(i).add(new Solu());
            }
        }
        for (int j = 1; j < nums.size(); j ++) {
            for (int i = 0; i < nums.size(); i ++ ) {
                if (i + j >= nums.size()) {
                    continue;
                }
                if (j == 1){
                    dp.get(i).get(j).valueFirst = Math.max(nums.get(i), nums.get(i + j));
                    dp.get(i).get(j).valueLast = Math.min(nums.get(i), nums.get(i + j));
                } else {
                    dp.get(i).get(j).valueFirst = Math.max(dp.get(i).get(j - 1).valueLast + nums.get(i + j), dp.get(i + 1).get(j - 1).valueLast + nums.get(i));
                    dp.get(i).get(j).valueLast = Math.min(dp.get(i).get(j - 1).valueFirst, dp.get(i + 1).get(j - 1).valueFirst);
                }
            }
        }
        return Math.max(dp.get(0).get(nums.size() - 1).valueFirst, dp.get(0).get(nums.size() - 1).valueLast);
    }


    @Test
    public void test() {
        int i = solution3("50 32 66 90".split(" "));
        System.out.println(i);
    }

    @Test
    public void test1() {
        int i = solution3("94 61 29 76 23 25 37 24 1 85 98 27".split(" "));
        System.out.println(i);
    }
}
