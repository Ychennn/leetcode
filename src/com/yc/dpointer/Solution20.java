package com.yc.dpointer;

public class Solution20 {//排序矩阵查找

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i--;
            else j++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = -5;
        boolean b = solution20.searchMatrix(matrix, target);
        System.out.println(b);
    }
}