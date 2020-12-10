package com.yc.top_medium;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {//螺旋矩阵⭐⭐⭐⭐⭐

    //比螺旋矩阵2稍难
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;

        while (true) {//控制条件可改为l<=r||t<=b
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);//从左至右
            if (++t > b) break;

            for (int i = t; i <= b; i++) res.add(matrix[i][r]);//从上到下
            if (--r < l) break;

            for (int i = r; i >= l; i--) res.add(matrix[b][i]);//从右到左
            if (--b < t) break;

            for (int i = b; i >= t; i--) res.add(matrix[i][l]);//从下到上
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[][] matrix = {{1, 2}};
        List<Integer> list = solution10.spiralOrder(matrix);
        System.out.println(list);
    }
}
