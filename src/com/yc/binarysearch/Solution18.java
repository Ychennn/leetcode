package com.yc.binarysearch;

public class Solution18 {//有序矩阵中第K小的元素⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int left = matrix[0][0];
        int right = matrix[n][n];
        while (left < right) {//最终终止条件left==right
            int mid = left + (right - left) / 2;
            int count = countNotMoreThanMid(matrix, mid, n);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int countNotMoreThanMid(int[][] matrix, int mid, int n) {//⭐⭐⭐⭐⭐
        int count = 0;
        int x = n;
        int y = 0;
        while (y <= n && x >= 0) {
            if (matrix[x][y] <= mid) {//如果当前值小于mid,说明这从0开始到这一列的这一行都比它小
                count += x + 1;       //count += x + 1;
                y++;                  //当前列后移,利用到了每列元素按升序排序的特点
            } else {
                x--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int i = solution18.kthSmallest(matrix, k);
        System.out.println(i);
    }
}