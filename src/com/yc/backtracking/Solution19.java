package com.yc.backtracking;

public class Solution19 {//单词搜索⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    private char[][] board;
    //标记对应元素是否被使用过
    private boolean[][] marked;

    //direction决定了如果符合当前条件,下一步走哪,该数组中元素的顺序会影响到递归的顺序
    private int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;//board的行数
    private int n;//board的列数
    private String word;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        //特殊判断
        if (m == 0) return false;
        n = board[0].length;
        this.board = board;//赋值
        marked = new boolean[m][n];//初始化
        this.word = word;//赋值
        this.board = board;//赋值

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //return dfs(i, j, 0);是错误的
                //因为如果该点不能成功直接返回false,后续的点根本没有dfs(...)
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

//        if (marked[i][j]) {
//            return false;
//        }//这一步可省略,因为第一次调用该方法时,当前的肯定是未被调用过的,
//        //而后续的点!marked[nextI][nextJ]也已被判断过,此步是多余的

        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;

            for (int k = 0; k < direction.length; k++) {
                int nextI = direction[k][0] + i;
                int nextJ = direction[k][1] + j;
                if (inArea(nextI, nextJ) && !marked[nextI][nextJ]) {
                    //如果该条路走得通,便直接返回,否者当前点,切换方向继续dfs(...)
                    if (dfs(nextI, nextJ, start + 1)) {
                        return true;
                    }
                }
            }
            //回溯
            marked[i][j] = false;
        }
        //以当前点所有路都走不通,返回false
        return false;
    }

    //判断当前给定的i,j是不是在board范围中
    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
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
