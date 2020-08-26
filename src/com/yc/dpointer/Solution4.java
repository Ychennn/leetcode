package com.yc.dpointer;

public class Solution4 {//二维数组中的查找⭐⭐⭐⭐⭐⭐⭐⭐

    //二分查找效率低,因为并未充分利用给定的条件
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //特判
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;
        //从二维数组的左下角开始遍历
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i--;
            else j++;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] matrix = new int[][]{
                {1, 4},
                {2, 5}
        };
        int target = 4;
        boolean b = solution4.findNumberIn2DArray(matrix, target);
        System.out.println(b);
    }
}
