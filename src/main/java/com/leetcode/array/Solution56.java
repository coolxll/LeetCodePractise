package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        if(intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for(int[] item:intervals) {
            int start = item[0];
            int end = item[1];
            if(result.isEmpty()) {
                result.add(new int[]{start, end});
            } else {
                int[] lastitem = result.get(result.size() - 1);
                int lastStart = lastitem[0];
                int lastEnd = lastitem[1];
                if(lastEnd >= start) {
                    lastitem[1] = Math.max(lastEnd, end);
                } else {
                    result.add(new int[]{start, end});
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }


    public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }

    public class Solution {
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            if(intervals == null || intervals.size() <= 1) return intervals;
            Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
            ArrayList<Interval> result = new ArrayList<>();
            for (int i = 0; i < intervals.size(); i++) {
                Interval interval = intervals.get(i);
                if (result.isEmpty()) {
                    result.add(interval);
                } else {
                    Interval lastInterval = result.get(result.size() - 1);
                    if(lastInterval.end >= interval.start) {
                        lastInterval.end = Math.max(lastInterval.end, interval.end);
                    } else {
                        result.add(interval);
                    }
                }
            }
            return result;
        }
    }
}
