package com.yc.dfs;

public class Solution16 {//岛屿数量

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {//当前点不为'1'直接跳过
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

        if (grid[i][j] == '1') {
            //防止重复判断,如{1,1}会死循环⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
            grid[i][j] = '0';
            //向右递归
            dfs(grid, i, j + 1);
            //向下递归
            dfs(grid, i + 1, j);
            //向左递归
            dfs(grid, i, j - 1);
            //向上递归
            dfs(grid, i - 1, j);
        }
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        char[][] grid = {
                {'0', '0'},
                {'0', '1'}
        };

        int i = solution16.numIslands(grid);
        System.out.println(i);
    }
}
