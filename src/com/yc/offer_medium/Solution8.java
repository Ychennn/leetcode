package com.yc.offer_medium;

public class Solution8 {//矩阵中的路径⭐⭐⭐⭐⭐⭐

    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从board[i][j]出发
                if (dfs(board, arr, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int idx) {
        //如果越界或当前board[i][j]!=word[idx]都直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ||
                board[i][j] != word[idx]) return false;

        //当匹配到最后一个字符,且通过上面的if即相等,返回true
        if (idx == word.length - 1) return true;

        //将board[i][j]标记为已访问
        board[i][j] = '\0';

        boolean b = dfs(board, word, i + 1, j, idx + 1) || dfs(board, word, i - 1, j, idx + 1) ||
                dfs(board, word, i, j + 1, idx + 1) || dfs(board, word, i, j - 1, idx + 1);

        //将board[i][j]标记为未访问(回溯)
        board[i][j] = word[idx];
        return b;
    }
}
