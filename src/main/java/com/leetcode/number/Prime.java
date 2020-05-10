package com.leetcode.number;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    private static List<Integer> primes;

    public static void main(String[] args) {
        if(primes == null) {
            primes = new ArrayList<>();
            primes.add(2);
        }

        for(int i=0;i<=100;i++) {
            if(isPrime(i)) {
                primes.add(i);
                System.out.println(i);
            }
        }
    }

    //判断是否是质数
    private static boolean isPrime(int i) {
        //只需要检查质数即可
        if(i == 1) return false;
        if(i == 2) return true;
        for(Integer k:primes) {
            if(i % k == 0) {
                return false;
            }
        }
        return true;
    }
}
