package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution12 {//地图分析⭐⭐⭐⭐⭐⭐⭐⭐

    public int maxDistance(int[][] grid) {//bfs
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        //标记是否有海洋
        boolean hasOcean = false;
        int[] point = null;

        while (!queue.isEmpty()) {
            point = queue.poll();

            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 0) {
                    continue;
                }

                //直接修改原数组,因此不需要额外的数组来标志是否访问,同时该点也记录了扩散的距离
                grid[newX][newY] = grid[x][y] + 1;

                hasOcean = true;

                queue.add(new int[]{newX, newY});
            }
        }

        //没有陆地或者没有海洋,返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        //返回最后一次遍历到的海洋的距离,-1是因为算上了自身的距离
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        int distance = solution12.maxDistance(grid);
        System.out.println(distance);
    }
}
