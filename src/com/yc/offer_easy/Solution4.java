package com.yc.offer_easy;

import java.util.Arrays;

public class Solution4 {//打印从1到最大的n位数

    public int[] printNumbers(int n) {//未考虑大数的情况
        int len = (int) Math.pow(10, n) - 1;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = solution4.printNumbers(1);
        System.out.println(Arrays.toString(nums));
    }
}
