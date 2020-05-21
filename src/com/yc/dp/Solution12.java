package com.yc.dp;

import java.util.Arrays;

public class Solution12 {//不同路径 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int uniquePaths(int m, int n) {//空间复杂度m*n
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {//空间优化,2n⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        int[] pre = new int[n];//当前行的前一行
        int[] curr = new int[n];//当前行
        Arrays.fill(pre, 1);
        Arrays.fill(curr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curr[j] = curr[j - 1] + pre[j];
            }
            pre = curr.clone();
        }
        return curr[n - 1];
    }

    public static int uniquePaths3(int m, int n) {//空间再优化,n⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        int[] curr = new int[n];//因为保存了前一行的数据，所有当前行直接在现有的curr上直接操作
        Arrays.fill(curr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curr[j] += curr[j - 1];
            }
        }
        return curr[n - 1];
    }

    public static void main(String[] args) {
        int i = uniquePaths3(7, 3);
        System.out.println(i);
    }
}
