package com.leetcode.greedy;

import java.util.Arrays;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,((a,b)->(a[1]-b[1])));
        int cnt = 0; //return cnt
        int i = 0;
        while(i<points.length) {
            int arrowWidth = points[i][1]; //射箭的x坐标
            int j = i + 1;
            while(j < points.length && points[j][0] <= arrowWidth) {
                j++;
            }
            cnt++;
            i = j;
        }
        return cnt;
    }
}
