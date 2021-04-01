package com.leetcode.string;

import org.junit.Test;

public class Solution468 {

    public String validIPAddress(String IP) {
        if(IP.chars().filter((c->c == '.')).count() == 3) {
            return validateIPV4(IP);
        }
        if(IP.chars().filter((c->c==':')).count() == 7) {
            return validateIPV6(IP);
        }
        return "Neither";
    }

    private String validateIPV6(String ip) {
        String[] nums = ip.split(":");
        String hexDigits = "0123456789ABCDEFabcdef";
        for(String num:nums) {
            if(num.length() == 0||num.length() > 4) return "Neither";
            for (char ch : num.toCharArray()) {
                if(hexDigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    private String validateIPV4(String ip) {
        String[] nums = ip.split("\\.");
        for (String num:nums) {
            //No Empty and between (0,255）
            if(num.length() == 0 || num.length() > 3) return "Neither";
            //If 0 then only 0
            if(num.charAt(0) == '0' && num.length() != 1) return "Neither";
            for (char ch : num.toCharArray()) {
                if(!Character.isDigit(ch)) return "Neither";
            }
            if(Integer.parseInt(num) > 255) return "Neither";
        }
        return "IPv4";
    }

    @Test
    public void test() {

    }
}
