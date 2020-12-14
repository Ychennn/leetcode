package com.yc.top_medium;

public class Solution17 {//生命游戏⭐⭐⭐⭐⭐

    public void gameOfLife2(int[][] board) {//使用额外空间
        int[] direction = {0, 1, -1};

        int[][] copy = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                int liveCount = 0;

                for (int k = 0; k < 3; k++) {//统计以自身为中心,8个方向细胞存活的数目
                    for (int l = 0; l < 3; l++) {
                        if (!(k == 0 & l == 0)) {
                            int tmpI = i + direction[k];
                            int tmpJ = j + direction[l];

                            if ((tmpI >= 0 && tmpI < copy.length) && (tmpJ >= 0 && tmpJ < copy[0].length)
                                    && copy[tmpI][tmpJ] == 1) {
                                liveCount++;
                            }
                        }
                    }
                }

                if ((copy[i][j] == 1) && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = 0;
                }

                if (copy[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void gameOfLife(int[][] board) {//原地修改,使用额外的状态
        int[] direction = {0, 1, -1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = 0;

                for (int k = 0; k < 3; k++) {//统计以自身为中心,8个方向细胞存活的数目
                    for (int l = 0; l < 3; l++) {
                        if (!(k == 0 & l == 0)) {
                            int tmpI = i + direction[k];
                            int tmpJ = j + direction[l];

                            if ((tmpI >= 0 && tmpI < board.length) && (tmpJ >= 0 && tmpJ < board[0].length)
                                    && Math.abs(board[tmpI][tmpJ]) == 1) {
                                liveCount++;
                            }
                        }
                    }
                }

                if ((board[i][j] == 1) && (liveCount < 2 || liveCount > 3)) {
                    //-1代表这个细胞过去是活的现在死了
                    board[i][j] = -1;
                }

                if (board[i][j] == 0 && liveCount == 3) {
                    //2代表这个细胞过去是死的现在活了
                    board[i][j] = 2;
                }
            }
        }
        //遍历board得到一次更新后的状态
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
