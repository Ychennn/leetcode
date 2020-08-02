package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution15 {//岛屿数量

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            grid[x][y] = '0';

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != '1') {
                    continue;
                }

                //入队之后立刻标记为'0',可防止大量重复数据入队列,造成严重超时
                //如不这样做的话 --> (x+1,y) 向右将 (x+1,y+1)入队列
                //而(x,y+1) 向下将 (x+1,y+1)入队列,而标记过后不会入队,大幅提高效率
                grid[newX][newY] = '0';
                queue.add(new int[]{newX, newY});
            }
        }
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        char[][] grid = {
                {'1', '1'},
                {'0', '1'}
        };
        int i = solution15.numIslands(grid);
        System.out.println(i);
    }
}
