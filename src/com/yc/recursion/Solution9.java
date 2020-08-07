package com.yc.recursion;

public class Solution9 {//数值的整数次方⭐⭐⭐⭐⭐⭐⭐

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        //虽然题目中告知不需要考虑大数问题
        //但是给出的n可以取到 -2147483648 ~ 2147483648(整型负数的最小值)
        long N = n;
        if (N < 0) {
            return 1 / helper(x, -N);
        }
        return helper(x, N);
    }

    private double helper(double x, long N) {//递归
        if (N == 0) return 1;

        if (x == 1) return 1;

        if (N % 2 == 0) {//分治法
            double square = helper(x, N / 2);
            return square * square;
        } else {
            double square = helper(x, (N - 1) / 2);
            return square * square * x;
        }
    }

    public double myPow2(double x, int n) {//快速幂⭐⭐⭐
        if (x == 1 || n == 0) return 1;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }
        double res = 1;

        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;

            N >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        double res = solution9.myPow(2, -1);
        System.out.println(res);
    }
}
