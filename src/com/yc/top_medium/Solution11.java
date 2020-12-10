package com.yc.top_medium;

import java.util.Arrays;

public class Solution11 {//螺旋矩阵2⭐⭐⭐⭐⭐

    public int[][] generateMatrix(int n) {
        //l:左边界,t:上边界,r:右边界,b:下边界
        int l = 0, t = 0, r = n - 1, b = n - 1;
        int val = 1;
        int target = n * n;
        int[][] matrix = new int[n][n];

        while (val <= target) {
            for (int i = l; i <= r; i++) matrix[t][i] = val++;//从左至右
            t++;//如{{1,2},{3,4}},第一个循环后{{1,2},{0,0}},第一层已经完成,上边界+1

            for (int i = t; i <= b; i++) matrix[i][r] = val++;//从上到下
            r--;//第二个循环后{{1,2},{0,3}},最后一列已经完成,右边界-1

            for (int i = r; i >= l; i--) matrix[b][i] = val++;//从右到左
            b--;//第三个循环后{{1,2},{4,3}},最后一层完成,下边界+1

            for (int i = b; i >= t; i--) matrix[i][l] = val++;//从下到上
            l++;//n=2时,不满足循环条件,不进入此该循环
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[][] matrix = solution11.generateMatrix(1);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
            //[1,2   -->    [1,2
            // 3,4]  -->     4,3]
        }
    }
}
