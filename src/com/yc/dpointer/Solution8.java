package com.yc.dpointer;


import java.util.Arrays;

public class Solution8 {//有序数组的平方⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[] sortedSquares(int[] A) {//双指针
        //用排序的方式效率低,且没有利用到给定数组已排序的特点
        int len = A.length;
        int[] res = new int[len];

        //左右指针
        int l = 0;
        int r = len - 1;
        int index = len - 1;

        while (l <= r) {//注意 <=
            int val;
            if (Math.abs(A[l]) >= Math.abs(A[r])) {
                val = A[l] * A[l];
                l++;
            } else {
                val = A[r] * A[r];
                r--;
            }
            res[index--] = val;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int[] A = new int[]{-4, -1, 0, 3, 10};
        int[] ints = solution8.sortedSquares(A);
        System.out.println(Arrays.toString(ints));
    }
}
