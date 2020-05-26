package com.yc.dp;


public class Solution26 {//最大正方形

    public static int maximalSquare(char[][] matrix) {//自己的方法
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];//为了便于matrix第一行和第一列matrix给dp[]赋值
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //dp[i + 1][j + 1]这是因为第一排和第一列的元素不满足动态规划方程,于是
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    index = dp[i + 1][j + 1] > index ? dp[i + 1][j + 1] : index;
                }
            }
        }
        return (int) Math.pow(index, 2);
    }

    public static int maximalSquare2(char[][] matrix) {//空间优化⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int index = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int pre = 0;//保存下一步对应所需的dp[i][j]
            for (int j = 0; j < n; j++) {
                int tmp = dp[j + 1];//临时变量保存dp[i][j]给下一步使用,
                // 如果只在这pre = dp[j + 1]; 下面的动态方程使用到的也不是正确的,使用到的是并不是dp[i][j]而是dp[i-1][j+1]
                if (matrix[i][j] == '1') {
                    //依次对应dp[i+1][j]，dp[i][j+1]，上一行的dp[i][j]
                    dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), pre) + 1;
                    index = dp[j + 1] > index ? dp[j + 1] : index;
                } else {
                    dp[j + 1] = 0;
                }
                pre = tmp;//如果只在这 pre = dp[j + 1];下一步使用的就不是dp[i][j]而是dp[i+1][j]了，综上使用tmp为中间量保存pre
            }
        }
        return (int) Math.pow(index, 2);
    }

    public static void main(String[] args) {
//        char[][] matrix = new char[][]{
//                {'0', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'}
        };
        int i = maximalSquare2(matrix);
        System.out.println(i);
    }
}
