package com.yc.hot100;

import java.util.*;

public class Solution9 {//合并区间⭐⭐⭐⭐⭐

    public int[][] merge(int[][] intervals) {//画图
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];

            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] nums = solution9.merge(intervals);
        for (int[] num : nums) System.out.println(Arrays.toString(num));
    }
}
