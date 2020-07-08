package com.yc.dp;

public class Solution11 {//视频拼接⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int videoStitching(int[][] clips, int T) {//贪心算法
        /*记录当前一轮，起始值，也就是上一轮的最大结束值*/
        int start = 0;
        /*记录结束值*/
        int currMax = 0;
        int count = 0;
        while (start < T) {
            currMax = 0;
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= start) {
                    currMax = Math.max(currMax, clips[i][1]);
                }
            }
            count++;
            if (currMax >= T) {
                return count;
            }
            if (currMax == start) {//说明已经找到当前数组的最大值，没有更大的了，而且不满足T，直接返回
                return -1;
            }
            start = currMax;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10);
        System.out.println(i);
    }
}
