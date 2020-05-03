package com.leetcode.bfs;

import com.leetcode.helper.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(); //用set去重，尽管题目里说List中无重复
        for (String s : wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) { //Fast fail
            return 0;
        }
        int l = beginWord.length();
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>(); //Queue for BFS
        queue.add(new Pair<>(beginWord, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Integer> item = queue.poll();
                //每一位进行替换，查看是否在字典里，在字典里的从字典去除，不能有环
                String cur = item.getKey();
                int step = item.getValue();
                char[] curCharArr= cur.toCharArray();
                for (int j = 0; j < l; j++) {
                    char orig = curCharArr[j];
                    for(char k = 'a'; k <= 'z'; k++) {
                        curCharArr[j] = k;
                        String newStr = String.valueOf(curCharArr);
                        if (newStr.equals(endWord)) {
                            return step + 1;
                        } else if (dict.contains(newStr)) {
                            queue.offer(new Pair<>(newStr, step + 1));
                            dict.remove(newStr);
                        } else {
                            continue;
                        }
                    }
                    curCharArr[j] = orig; //还原回去
                }

            }
        }
        return 0; //fail to find
    }
}
