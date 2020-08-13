package com.yc.binarysearch;

public class Solution9 {//统计有序矩阵中的负数

    public int countNegatives(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            res += grid[i].length - index(grid[i]);
        }
        return res;
    }

    //获取索引index(第一个非负数索引+1)
    //再用grid[i].length - index(grid[i])即可得出负数的个数
    private int index(int[] grid) {
        int left = 0;
        int right = grid.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (grid[mid] >= 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int[][] grid = new int[][]{
                {3, -1},
                {1, 0}
        };
        int i = solution9.countNegatives(grid);
        System.out.println(i);
    }
}
