package com.yc.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution17 {//01矩阵⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int bfs = bfs(matrix, i, j);
                    matrix[i][j] = bfs;
                }
            }
        }
        return matrix;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};//方位
    private int bfs(int[][] matrix, int i, int j) {//bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int min = 0;

        while (!queue.isEmpty()) {

            for (int k = queue.size(); k > 0; k--) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for (int l = 0; l < 4; l++) {
                    if (x + dx[l] < 0 || x + dx[l] >= matrix.length ||
                            y + dy[l] < 0 || y + dy[l] >= matrix[0].length) {
                        continue;
                    }

                    //直接处理防止添加重复数据
                    if (matrix[x + dx[l]][y + dy[l]] == 0) return min + 1;

                    queue.add(new int[]{x + dx[l], y + dy[l]});
                }
            }
            min++;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        int[][] matrix = new int[][]{//不能全为1
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] ints = solution17.updateMatrix(matrix);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
