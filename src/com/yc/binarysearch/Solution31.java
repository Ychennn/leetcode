package com.yc.binarysearch;

public class Solution31 {//搜索二维矩阵

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n;
        int mid;
        int midVal;
        while (left < right) {
            mid = left + (right - left) / 2;
            midVal = matrix[mid / n][mid % n];
            if (midVal == target) return true;
            else if (midVal < target) left = mid + 1;
            else right = mid;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        boolean b = solution31.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
