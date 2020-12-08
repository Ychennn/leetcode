package com.yc.top_medium;

public class Solution5 {//Pow(x, n)⭐⭐⭐⭐⭐

    public double myPow(double x, int n) {//快速幂
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;

        long b = n;//先用long接收,否则当n取-2147483648,直接调用(Math.abs(int n))会溢出
        boolean isPositive = n > 0;
        b = Math.abs(b);//用Math.abs(long a)

        double res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return isPositive ? res : 1 / res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        double i = solution5.myPow(2.00000, -2147483648);
        System.out.println(i);
    }
}
