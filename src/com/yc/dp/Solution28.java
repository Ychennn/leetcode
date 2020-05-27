package com.yc.dp;

import java.util.Arrays;

public class Solution28 {//零钱兑换⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int coinChange(int[] coins, int amount) {//动态规划
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);//表示不能兑换该价值的零钱
        dp[0] = 0;//这一步初始化0
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {//该层循环可以看做此次内循环只使用前i种硬币兑换
                //必须为>=0,否者会出现如1,2,5等不能被兑换
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    //转换方程如11-->dp[10]+1,dp[9]+2,dp[6]+5
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];//不能兑换则返回-1
    }

    public static int coinChange2(int[] coins, int amount) {//套[完全背包]问题的公式
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);//表示不能兑换该价值的零钱
        dp[0] = 0;//这一步初始化0
        for (int coin : coins) {//这里循环虽然会出现如6-->dp[1]+5,dp[5]+1,但结果跟顺序无关,可以采用
            for (int i = 0; i < amount + 1; i++) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];//不能兑换则返回-1
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int i = coinChange2(coins, 11);
        System.out.println(i);
    }
}
