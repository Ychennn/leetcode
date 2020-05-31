package com.yc.dp;

public class Solution34 {//股票的最大利润

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > 0) {
//                if (prices[i] - minPrice > maxProfit) {
//                    maxProfit = prices[i] - minPrice;
//                }
                maxProfit = prices[i] - minPrice > maxProfit ? prices[i] - minPrice : maxProfit;
            } else {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {//动态规划法
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < dp.length; i++) {
            if (prices[i] > minPrice) {
                dp[i] = prices[i] - minPrice > dp[i - 1] ? prices[i] - minPrice : dp[i - 1];
            } else {
                minPrice = prices[i];
                dp[i] = dp[i - 1];
            }
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int i = maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
