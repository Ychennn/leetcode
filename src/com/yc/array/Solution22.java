package com.yc.array;

public class Solution22 {//统计全为 1 的正方形子矩阵

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m, n);
        int count = 0;
        boolean[][][] booleans = new boolean[m][n][len];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                booleans[i][j][0] = (matrix[i][j] == 1);
                count += booleans[i][j][0] == true ? 1 : 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < len; k++) {
                    booleans[i][j][k] = (matrix[i][j] == 1 && booleans[i - 1][j][k - 1] &&
                            booleans[i][j - 1][k - 1] && booleans[i - 1][j - 1][k - 1]);//✳✳✳✳✳✳✳✳✳
                    count += booleans[i][j][k] == true ? 1 : 0;
                }
            }
        }

        return count;
    }

    public static int countSquaresPro(int[][] matrix) {//优化
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
                if(matrix[i][j]==1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+1;
                    count += dp[i][j];
                }
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
        int i = countSquaresPro(ints);
        System.out.println(i);
    }
}
