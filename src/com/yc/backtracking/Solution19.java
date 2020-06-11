package com.yc.backtracking;

public class Solution19 {//单词搜索

    public boolean exist(char[][] board, String word) {
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Solution19 solution19 = new Solution19();
        boolean see = solution19.exist(board, "ABCCED");
        System.out.println(see);
    }
}
