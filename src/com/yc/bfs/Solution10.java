package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution10 {//腐烂的橘子⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int orangesRotting(int[][] grid) {//多源广度优先搜索
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;//鲜橘子的数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (count == 0) return 0;

        int minutes = 0;//分钟数
        //count > 0 ,此时橘子已经全部腐烂,但队列还有数据未进行处理,实际上不需要再进行下一步处理⭐⭐⭐
        while (!queue.isEmpty() && count > 0) {
            minutes++;
            //多个点同时向四周扩散
            for (int k = queue.size(); k > 0; k--) {
                int[] poll = queue.poll();

                int i = poll[0];
                int j = poll[1];

                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {//右扩散
                    count--;
                    grid[i][j + 1] = 2;
                    queue.add(new int[]{i, j + 1});
                }

                if (i - 1 >= 0 && grid[i - 1][j] == 1) {//下扩散
                    count--;
                    grid[i - 1][j] = 2;
                    queue.add(new int[]{i - 1, j});
                }

                if (j - 1 >= 0 && grid[i][j - 1] == 1) {//做扩散
                    count--;
                    grid[i][j - 1] = 2;
                    queue.add(new int[]{i, j - 1});
                }

                if (i + 1 < grid.length && grid[i + 1][j] == 1) {//上扩散
                    count--;
                    grid[i + 1][j] = 2;
                    queue.add(new int[]{i + 1, j});
                }
            }
        }
        return count > 0 ? -1 : minutes;//最终结果如果鲜橘子数量>0,说明有的橘子不可达,返回-1
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int i = solution10.orangesRotting(grid);
        System.out.println(i);
    }
}
