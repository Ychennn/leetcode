package com.yc.dp;

public class Solution13 {//不同路径2 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;//因为dp创建完后未赋值时都为0，不设为1的话，后面+=前面的值依然为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }

                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        int i = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        int i = uniquePathsWithObstacles(new int[][]{{1}});
//        int i = uniquePathsWithObstacles(new int[][]{{1, 0}});
//        int i = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {1, 1, 1}, {0, 0, 0}});
        System.out.println(i);
    }
}
