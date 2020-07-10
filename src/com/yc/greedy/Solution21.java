package com.yc.greedy;

import java.util.Arrays;

public class Solution21 {//用最少数量的箭引爆气球⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int findMinArrowShots(int[][] points) {//按照开始位进行升序排序
        if (points.length < 2) return points.length;

        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        //int start = points[0][0];//记录开始位置,实际上不需要使用,可省略
        int end = points[0][1];//记录目前线段能够达到的最远位置
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                //start = points[i][0];
                end = points[i][1];
            } else {
                //start = points[i][0];
                end = Math.min(end, points[i][1]);
            }
        }
        return count;
    }

    public int findMinArrowShots2(int[][] points) {//按照结束位进行升序排序
        if (points.length < 2) return points.length;

        Arrays.sort(points, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int end = points[0][1];//记录目前线段能够达到的最远位置
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = solution21.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}
