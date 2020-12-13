package com.yc.top_medium;

import java.util.Arrays;

public class Solution14 {//矩阵置零⭐⭐⭐⭐⭐
    //也可以使用2个HashSet,循环遍历数组,如果matrix[i][j]==0
    //就将对应的row和col放入对应的集合中,再次遍历,如果该行或列在hashSet中有值
    //(即该行或列有0)matrix[i][j]=0

    public void setZeroes(int[][] matrix) {//空间优化后
        boolean col_flag = false;//标志第一列是否有0
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            //如果第一列有0,标志置为true
            if (matrix[i][0] == 0) col_flag = true;

            //从第一列开始,如果matrix[i][j] == 0
            //对应的matrix[i][0],matrix[0][j]都置零
            //即使用第一行和第一列来标志该行该列是否置零
            for (int j = 1; j < col; j++) {//⭐⭐⭐
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //从索引{1,1}开始遍历,如果对应标志位(matrix[i][0],matrix[0][j])为0,该位置零
        //不能从{0,0}开始否则第一行第一列可能全部置0,导致整个数组全部置0⭐⭐⭐
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //如果matrix[0][0] == 0,第一行全部置0
        if (matrix[0][0] == 0) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        //如果第一列有零,把第一列全部置0
        if (col_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        solution14.setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
