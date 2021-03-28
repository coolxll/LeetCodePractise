package com.leetcode.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Offer50 {

    public char firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(!charMap.containsKey(c)) {
                charMap.put(c,i);
            } else {
                charMap.put(c,-1);
            }
        }
        Character character = charMap.entrySet().stream().filter((o) -> (o.getValue() != -1)).min((Comparator.comparing(Map.Entry::getValue))).map(Map.Entry::getKey).orElse(' ');
        return character;
    }
}
