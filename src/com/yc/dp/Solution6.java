package com.yc.dp;

public class Solution6 {//使用最小花费爬楼梯

    public static int minCostClimbingStairs(int[] cost) {//自己的方法
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int min = 0;
        for (int i = 2; i < cost.length; i++) {
            dp[i] += Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static int minCostClimbingStairs2(int[] cost) {//简化
        int prev2 = 0;//记录前一个的前一个dp数
        int prev = 0;//记录前一个dp数
        for (int i = 0; i < cost.length; i++) {
            // 记录前一个dp数的值，为prev2的赋值做准备
            int tmp = prev;
            // 因为走到这一步的，可能是前一个阶梯的，也可能是前两个阶梯的，因此求这两个地方的最小值
            prev = Math.min(prev, prev2) + cost[i];
            // 向右移动一位
            prev2 = tmp;
        }
        return Math.min(prev2, prev);
    }

    public static void main(String[] args) {
//        int i = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        int i = minCostClimbingStairs2(new int[]{1, 10, 1, 1});
        System.out.println(i);
    }
}
