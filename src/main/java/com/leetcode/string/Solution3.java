package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    private int count = 0;
    private Set<Character> hashSet = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        char[] charArray = s.toCharArray();
        int i = 0, j = 0,size = charArray.length;
        while(i < size && j < size) {
            char newAddChar = charArray[j]; //substring 不包括j下标的
            if(isUnique(newAddChar)) {
                longestLength = Math.max(longestLength, (j - i + 1));
                j++;
            } else {
                hashSet.remove(charArray[i]);
                i++;
            }

        }
        return longestLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    private boolean isUnique(char c) { //改进
        if(hashSet.contains(c)) {
            return false;
        } else {
            hashSet.add(c);
            return true;
        }
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
