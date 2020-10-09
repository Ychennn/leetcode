package com.yc.bit;

public class Solution6 {//两整数之和⭐⭐⭐⭐⭐⭐

    public int getSum(int a, int b) {
        int tmp;
        while (b != 0) {
            //各位相加的值
            tmp = a ^ b;

            //进位的值
            b = (a & b) << 1;

            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int sum = solution6.getSum(1, 3);
        System.out.println(sum);
    }
}
