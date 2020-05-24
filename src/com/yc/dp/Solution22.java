package com.yc.dp;

public class Solution22 {//只有两个键的键盘 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int minSteps(int n) {//暴力DP
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    min = Math.min(min, dp[j] + i / j);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static int minSteps2(int n) {//DP优化
        int[] dp = new int[n + 1];
        int len = (int)Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;//素数就等与自身
            for (int j = 2; j <=len; j++) {//<=
                if (i % j == 0) {
                    //如12可以转换成2+6，6则可以继续向下转换,为什么转换方程是这个？
                    // 因为任何非素数都可以被2或3整除，2和3都等于本身，
                    // dp[j]+i-j ---->dp[j] + dp[i / j];如何12可以最终转换成2*2*3 ---->2+2+3
                    dp[i] = dp[j] + dp[i / j];
                    break;//因为12=2*6或3*4结果是 一样的，所以找到就立刻返回
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int i = minSteps2(2);
        System.out.println(i);
    }
}

