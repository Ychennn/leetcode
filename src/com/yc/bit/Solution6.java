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

    public int add(int a, int b) {//递归,同理
        if (b == 0) return a;

        //各位数之和 + 进位
        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int sum = solution6.getSum(1, 3);
        System.out.println(sum);
    }
}
