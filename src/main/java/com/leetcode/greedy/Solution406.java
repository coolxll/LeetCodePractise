package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 */
public class Solution406 {

    private static int compare(int[] a, int[] b) {
        if (b[0] != a[0]) {
            return b[0] - a[0]; //身高降序
        } else {
            return a[1] - b[1]; //对于k按升序排列
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Solution406::compare); //先按身高降序出现次数升序排列
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1],p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
