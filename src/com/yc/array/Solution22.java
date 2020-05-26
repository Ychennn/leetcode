package com.yc.array;

public class Solution22 {//统计全为 1 的正方形子矩阵

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        // 预处理第一行和第一列
        for (int i = 0; i < m; i++) {
            count += dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            count += dp[0][j] = matrix[0][j];
        }
        // 上述过程(0, 0)判断了两次, 如果matrix[0][0] == 1，说明ans多算了一个
        if (matrix[0][0] == 1) {
            count--;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    count += dp[i][j];
                }
            }
        }
        return count;
    }

    public static int countSquares2(int[][] matrix) {//空间优化
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int pre = 0;
            for (int j = 0; j < n; j++) {
                int tmp = dp[j + 1];//保存当前的dp[i][j+1]给下一步使用
                if (matrix[i][j] == 1) {
                    dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), pre) + 1;
                    if (dp[j + 1] > 0) count += dp[j + 1];
                } else {
                    dp[j + 1] = 0;
                    //必须置零，因为该位置上还保存着dp[i][j+1]的值，否者会造成错误的结果(偏大)
                }
                pre = tmp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int i = countSquares2(ints);
        System.out.println(i);
    }
}
