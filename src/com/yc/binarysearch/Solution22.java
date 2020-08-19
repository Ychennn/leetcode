package com.yc.binarysearch;

public class Solution22 {//两数相除⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int divide(int dividend, int divisor) {

        //题目要求：如果除法结果溢出,则返回 2^31 − 1
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        //flag表示是否全为正数或负数,返回结果时需用该值进行判断
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        //统一转换为负数进行处理,如果统一转换成正数当其中有值取Integer.MIN_VALUE时
        //会出现越界问题
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int res = 0;

        while (dividend <= divisor) {//核心逻辑
            int c = 1;
            int tmp = divisor;

            while (dividend - tmp <= tmp) {
                c <<= 1;
                tmp <<= 1;
            }
            res += c;
            dividend -= tmp;
        }

        return flag ? res : -res;
    }

    public static void main(String[] args) {
        int a = -3;
        a = -a;
        System.out.println(a);
    }
}
