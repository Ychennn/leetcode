package com.yc.bit;

public class Solution23 {//整数替换⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int integerReplacement(int n) {
        //特殊处理,因为Integer.MAX_VALUE为奇数,加1时会溢出
        if (n == Integer.MAX_VALUE) return 32;

        if (n <= 3) return n - 1;

        if ((n & 1) == 0) return integerReplacement(n / 2) + 1;
        else return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
    }


    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        int i = solution23.integerReplacement(8);
        System.out.println(i);
    }
}
