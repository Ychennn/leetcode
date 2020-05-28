package com.yc.dp;

public class Solution30 {//礼物的最大值

    public static int maxValue(int[][] grid) {//自己的方法
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i > 0 && j > 0) grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                else if (j > 0) grid[i][j] += grid[i][j - 1];
                else if (i > 0) grid[i][j] += grid[i - 1][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] gird = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int i = maxValue(gird);
        System.out.println(i);
    }
}