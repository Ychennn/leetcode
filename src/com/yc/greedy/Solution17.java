package com.yc.greedy;


import java.util.Arrays;

public class Solution17 {//任务调度器⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int leastInterval(char[] tasks, int n) {//贪心算法
        int[] map = new int[26];//记录每个任务的执行次数
        for (char task : tasks) {
            map[task - 'A'] += 1;
        }

        int time = 0;//总的执行时间
        int i;//同一个任务相隔时间最少为n,所以将n + 1 个任务当做一轮
        Arrays.sort(map);//优先解决次数最多的任务

        while (map[25] > 0) {
            i = 0;

            while (i <= n) {
                if (map[25] == 0) {
                    break;
                }
                if (i < 26 && map[25 - i] > 0) {//i < 26是为了防止(间隔时间 > 26)的情况
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            //再次排序
            Arrays.sort(map);
        }
        return time;
    }

    public int leastInterval2(char[] tasks, int n) {//桶思想,具体思路看官方题解
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A'] += 1;
        }
        Arrays.sort(map);
        int maxVal = map[25] - 1;
        int space = maxVal * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            space -= Math.max(maxVal, map[i]);
        }

        return space > 0 ? space + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int i = solution17.leastInterval(tasks, n);
        System.out.println(i);
    }
}
