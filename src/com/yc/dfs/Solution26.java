package com.yc.dfs;

import java.util.Arrays;

public class Solution26 {//被围绕的区域⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    //方位
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    //从边界且值为'O'的点开始向 右->下->上->左 的顺序递归查找
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        //把K改成O，其他改成X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'K';

        for (int k = 0; k < dx.length; k++) {
            dfs(board, i + dx[k], j + dy[k]);
        }
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}

        };
        solution26.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
