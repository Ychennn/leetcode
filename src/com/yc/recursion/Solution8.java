package com.yc.recursion;

public class Solution8 {//第K个语法符号⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int kthGrammar(int N, int K) {
        return helper(N, K, 0);
    }

    private int helper(int N, int K, int flag) {
        if (N == 1) return flag;
        int half = (1 << (N - 2));
        if (K <= half) {
            return helper(N - 1, K, flag);
        } else {
            return helper(N - 1, K - half, 1 - flag);
        }
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int i = solution8.kthGrammar(4, 5);
        System.out.println(i);
    }
}
