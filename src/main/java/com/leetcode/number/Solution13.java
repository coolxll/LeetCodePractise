package com.leetcode.number;

import org.junit.Test;

public class Solution13 {

    enum RomanInt {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),
        IV(4),
        IX(9),
        XL(40),
        XC(90),
        CD(400),
        CM(900)
        ;

        int value;

        RomanInt(int value) {
            this.value = value;
        }

    }

    public int romanToInt(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'I' || c == 'X' || c == 'C') { //check double digit
                if( i + 1 < charArray.length) {
                    char c1 = charArray[i+1];
                    String cc = new StringBuilder().append(c).append(c1).toString();
                    boolean twocharflag = false;
                    for(RomanInt choice:RomanInt.values()) {
                        if(choice.name().equals(cc)) {
                            result += choice.value;
                            i++;
                            twocharflag = true;
                            break;
                        }
                    }
                    if(twocharflag) continue;
                }
            }
            String cc = "" + c;
            result += RomanInt.valueOf(cc).value;

        }
        return result;
    }

    @Test
    public void test() {
        int anInt = romanToInt("IX");
        System.out.println(anInt);
    }
}
