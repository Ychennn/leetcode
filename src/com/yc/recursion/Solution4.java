package com.yc.recursion;

public class Solution4 {//青蛙跳台阶问题

    int[] arr = new int[101];

    public int numWays(int n) {//记忆化递归
        if (n < 0) return 0;
        if (n <= 1) return 1;

        if (arr[n] != 0) return arr[n];

        int res = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        arr[n] = res;
        return arr[n];
    }

    public int numWays2(int n) {//dp
        if (n <= 1) return 1;
        int pre0 = 1;
        int pre1 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (pre0 + pre1) % 1000000007;
            pre0 = pre1;
            pre1 = res;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int i = solution4.numWays(7);
        System.out.println(i);
    }
}
