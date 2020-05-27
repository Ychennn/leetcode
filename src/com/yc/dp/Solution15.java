package com.yc.dp;

public class Solution15 {//硬币⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐背包问题

    public static int waysToChange(int n) {//二维数组法
        int[] coins = new int[]{1, 5, 10, 25};//硬币必须为非递减的
        int[][] dp = new int[5][n + 1];

        for (int i = 1; i < 5; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < 5; i++) {//外层循环对应为只用前i中硬币
            for (int j = 1; j <= n; j++) {
                if (j - coins[i - 1] < 0) {                   // 要组成的面值比当前硬币金额小，该硬币不可以选择
                    dp[i][j] = dp[i - 1][j] % 1000000007;  // 只能由 i - 1 中硬币来组成面值 j
                } else {
                    // 当前硬币可以不选，也可以选择
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    public static int waysToChange2(int n) {//一维数组法
        int[] dp = new int[n + 1];
        int[] coins = {1, 5, 10, 25};
        dp[0] = 1;
        for (int coin : coins) {//内外顺序不能交换，防止重复 如(1,5)和(5,1),层循环对应为只用前i中硬币
            for (int i = coin; i <= n; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = waysToChange(10);
        System.out.println(i);
    }
}

