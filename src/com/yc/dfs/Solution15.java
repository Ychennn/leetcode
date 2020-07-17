package com.yc.dfs;

public class Solution15 {//岛屿的最大面积⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int maxAreaOfIsland(int[][] grid) {//中心扩散法
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = getArea(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int getArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return 0;
        if (j < 0 || j >= grid[0].length) return 0;

        //递归的以当前为中心扩散向四周计算
        if (grid[i][j] == 1) {
            grid[i][j] = 0;//避免重复查找,如{1,1}会死循环 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
            return 1 + getArea(grid, i + 1, j) + getArea(grid, i - 1, j) +
                    getArea(grid, i, j + 1) + getArea(grid, i, j - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[][] gird = new int[][]{
                {1, 1},
                {1, 1},
        };
        int i = solution15.maxAreaOfIsland(gird);
        System.out.println(i);
    }
}
