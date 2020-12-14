package com.yc.top_medium;

public class Solution16 {//有效的数独⭐⭐⭐⭐⭐

    public boolean isValidSudoku(char[][] board) {
        //rows[i]代表第i+1行,rows[i][j]代表第i+1行,j+1这个数出现的次数
        int[][] rows = new int[9][9];
        //cols[i][j]同理
        int[][] cols = new int[9][9];
        //boxes代表第i+1个"3*3"子数独中对应数字出现的次数
        int[][] boxes = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                //减去'1',是为了和数组的索引对应,出现的数字范围:1-9
                //索引范围:0-8
                int num = board[i][j] - '1';

                rows[i][num]++;
                cols[j][num]++;
                int boxIdx = (i / 3) * 3 + j / 3;
                boxes[boxIdx][num]++;

                if (rows[i][num] > 1 || cols[j][num] > 1 ||
                        boxes[boxIdx][num] > 1)
                    return false;
            }
        }

        return true;
    }
}
