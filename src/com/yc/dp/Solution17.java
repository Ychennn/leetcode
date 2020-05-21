package com.yc.dp;

public class Solution17 {//不同的二叉搜素树I ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int numTrees(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        /*
        G(n): 长度为n的序列的不同二叉搜索树个数。====>dp[n+1]
        F(i, n): 以i为根的不同二叉搜索树个数(1<= i <=n)。
        G(n) = 从1到n的F(i, n)的和
        因为F(i,n)=G(i−1)⋅G(n−i) 如求F(3,7)=G(2)⋅G(4)
        因此可以转换成G(n) = G(i−1)⋅G(n−i) 从1到n的和
        */
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {//j代表F(i, n)中的i,i则对应n
                dp[i] += dp[j - 1] * dp[i - j];//内层循环对应G(i−1)⋅G(n−i)
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }
}
