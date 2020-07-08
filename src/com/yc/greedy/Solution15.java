package com.yc.greedy;

import java.util.Arrays;

public class Solution15 {//无重叠区间⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int eraseOverlapIntervals(int[][] intervals) {//以起点的贪心算法
        if (intervals.length == 0) return 0;

        //对intervals二维数组依照区间起始值进行排序(Lambda)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int prev = 0;
        int count = 0;

        //分三种情况考虑：
        //intervals[i][0] > intervals[prev][1]
        //intervals[i][0] < intervals[prev][1]&&intervals[0][1] < intervals[prev][1]
        //intervals[i][0] < intervals[prev][1]&&intervals[0][1] > intervals[prev][1]
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {//以终点的贪心算法
        if (intervals.length == 0) return 0;

        //对intervals二维数组依照区间结束值进行排序(Lambda)
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int prev = 0;
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[prev][1]) {
                if (intervals[i][1] < intervals[prev][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
//        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals = new int[][]{{1, 2}, {2, 3}};
        int i = solution15.eraseOverlapIntervals2(intervals);
        System.out.println(i);
    }
}
