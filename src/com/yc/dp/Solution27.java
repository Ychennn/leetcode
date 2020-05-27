package com.yc.dp;

import java.util.Arrays;

public class Solution27 {//比特位计数

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            result[i] = popcount(i);
        }
        return result;
    }

    private static int popcount(int x) {
        int count = 0;
        for (; x != 0; count++) {
            x &= x - 1;//位与运算，完成循环后能计算出有多少个1
        }
        return count;
    }

    public static int[] countBits2(int num) {//动态规划
        int[] dp = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            //考虑两种情况,如果是偶数,如2-->10 4-->100 就可以理解为直接将/2 的dp[i]右移得到
            if (i % 2 == 0) dp[i] = dp[i / 2];
                //如果是奇数,如4-->100 5-->101 即将dp[i-1]直接加1得到
            else dp[i] = dp[i - 1] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] ints = countBits2(10);
        System.out.println(Arrays.toString(ints));
    }
}
