package com.yc.array;

import java.util.Arrays;

public class Solution2 {//旋转矩阵

    public static void rotate(int[][] matrix) {
        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        int tmp2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                tmp2 = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - j - 1] = matrix[i][j];
                matrix[i][j] = tmp2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}