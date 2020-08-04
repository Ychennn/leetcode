package com.yc.recursion;


public class Solution2 {//第 N 个泰波那契数⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    private int[] dp = new int[38];

    public int tribonacci(int n) {//记忆化递归⭐⭐⭐⭐
        if (n <= 0) return 0;
        if (n == 1) return 1;

        if (dp[n] != 0) return dp[n];//写在前面两个判断之后,防止越界

        int res = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        dp[n] = res;
        return res;
    }

    public int tribonacci2(int n) {//dp
        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int tribonacci = solution2.tribonacci(25);
        System.out.println(tribonacci);
    }
}
