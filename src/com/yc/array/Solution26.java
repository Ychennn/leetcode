package com.yc.array;

import java.util.Arrays;

public class Solution26 {//重塑矩阵

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c || nums.length == r || nums.length == 0) {
            return nums;
        }
        int count = 0;
        int[][] result = new int[r][c];
        for (int[] num : nums) {
            for (int i : num) {
                result[count / c][count % c] = i;
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}};
        int[][] ints = matrixReshape(nums, 2, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
