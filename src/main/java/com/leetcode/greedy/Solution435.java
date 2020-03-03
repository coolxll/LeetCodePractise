package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //先考虑特殊情况
        if(intervals == null || intervals.length == 1) return 0;
        //第一步先排序，按照后端点来排序
        Arrays.sort(intervals,((a,b)->(a[1]-b[1])));
        int i=0,j=0;
        int count=0; //the result to return
        while(i<intervals.length) {
            int right = intervals[i][1]; //每个数组的右端点
            j=i+1;
            while(j<intervals.length && intervals[j][0] < right) { //不要越界且有相交
                j++;
            }
            count += (j-i) - 1;
            i = j; //注意 不要跳到j+1
        }
        return count;
    }
}
