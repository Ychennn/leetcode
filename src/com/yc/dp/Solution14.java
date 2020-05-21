package com.yc.dp;

public class Solution14 {//最小路径和

    public static int minPathSum(int[][] grid) {//自己的方法
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    grid[i][0] += i > 0 ? grid[i - 1][j] : 0;
                    continue;
                } else if (i == 0) {
                    grid[0][j] += j > 0 ? grid[0][j - 1] : 0;
                    continue;//返回
                }

                if (i > 0 && j > 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int i = minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
        System.out.println(i);
    }
}
