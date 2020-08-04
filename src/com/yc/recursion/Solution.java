package com.yc.recursion;

import java.util.Arrays;

public class Solution {//跳水板⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[] divingBoard(int shorter, int longer, int k) {//数学法
        if (k == 0) return new int[]{};

        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] result = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            result[i] = i * longer + (k - i) * shorter;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.divingBoard(1, 2, 3);
        System.out.println(Arrays.toString(ints));
    }
}
