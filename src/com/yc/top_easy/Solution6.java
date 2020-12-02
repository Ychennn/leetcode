package com.yc.top_easy;

import java.util.Arrays;

public class Solution6 {//加一⭐⭐⭐⭐⭐

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            //如果当前位,digits[i]<10,即不会再向前进位,直接返回
            if (digits[i] / 10 == 0) return digits;
            digits[i] %= 10;
        }

        //如果for循环后没有返回,说明遇到了如{9,9},{9}这种数组
        //新建数组(长度为原来的+1),并使res[0] = 1,返回该数组
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] digits = {9, 9};
        int[] plusOne = solution6.plusOne(digits);
        System.out.println(Arrays.toString(plusOne));
    }
}
