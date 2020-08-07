package com.yc.recursion;

public class Solution7 {//递归乘法⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int multiply(int A, int B) {//代码更简洁
        if (A > B) return multiply(B, A);//交换值,减少计算量

        if (A == 0) return 0;

        return B + multiply(--A, B);
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int multiply = solution7.multiply(10, 1);
        System.out.println(multiply);
    }
}
