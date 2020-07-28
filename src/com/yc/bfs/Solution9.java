package com.yc.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution9 {
    private static class Point {//被围绕的区域⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }
        
        //把K改成O，其他改成X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            if (tmp.x >= 0 && tmp.x < board.length && tmp.y >= 0 && tmp.y < board[0].length && board[tmp.x][tmp.y] == 'O') {
                board[tmp.x][tmp.y] = 'K';
                queue.add(new Point(tmp.x + 1, tmp.y));//注意这里的值,不要填成i+1,j
                queue.add(new Point(tmp.x - 1, tmp.y));
                queue.add(new Point(tmp.x, tmp.y + 1));
                queue.add(new Point(tmp.x, tmp.y - 1));
            }
        }
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        char[][] board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solution9.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
