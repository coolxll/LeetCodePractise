package com.leetcode.backtracking;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {

    private char[][] digitMap = new char[10][];

    {
        digitMap[0] = new char[]{};
        digitMap[1] = new char[]{};
        digitMap[2] = new char[]{'a', 'b', 'c'};
        digitMap[3] = new char[]{'d', 'e', 'f'};
        digitMap[4] = new char[]{'g', 'h', 'i'};
        digitMap[5] = new char[]{'j', 'k', 'l'};
        digitMap[6] = new char[]{'m', 'n', 'o'};
        digitMap[7] = new char[]{'p', 'q', 'r', 's'};
        digitMap[8] = new char[]{'t', 'u', 'v'};
        digitMap[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    /**
     * T9 输入法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits != null && digits.length() > 0) { dfs(digits, result, 0, ""); }
        return result;
    }

    private void dfs(String input,List<String> result,int begin,String prefix) {
        int c = input.charAt(begin) - '0';
        char[] possible_chars = digitMap[c];
        boolean last_digit = begin == input.length() - 1;
        for (char ch : possible_chars) {
            if(last_digit) {
                result.add(prefix + ch);
            } else {
                dfs(input, result, begin + 1, prefix + ch);
            }
        }
    }

    @Test
    public void test() {
        List<String> strings = letterCombinations("23");
        System.out.println(JSON.toJSONString(strings));
    }
}
