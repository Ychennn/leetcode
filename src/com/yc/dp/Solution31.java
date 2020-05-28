package com.yc.dp;

public class Solution31 {//最佳买卖股票的时机含冷冻期⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int maxProfit(int[] prices) {//自己的方法一遍过
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];//初始化dp[]

        dp[0][0] = 0;//表示不持股
        dp[0][1] = -prices[0];//表示持股
        // 这里也可以再多加个状态用来表示冷冻期dp[i][2] = dp[i - 1][0];

        for (int i = 1; i < len; i++) {
            /*今天不持股的最大利润可以由昨天也不持股和昨天持股今天卖出的较大值得出，
            由于昨天持股的利润是已经减去了买进和手续费，所以直接加今天的prices[i]即可得到利润*/
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /*今天持股的最大利润可以由昨也不持股和前天不持股
            (因为冷冻期，不能再卖出后的第二天再次购买股票)比较得出*/
            dp[i][1] = i - 2 >= 0 ? Math.max(dp[i - 1][1],
                    dp[i - 2][0] - prices[i]) : Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static int maxProfit2(int[] prices) {//空间优化
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int pre0 = 0;//表示dp[i-1][0]
        int pre1 = -prices[0];//表示dp[i-1][1]
        int pre2 = 0;//表示dp[i-1][2]

        int curr0;//当前dp[i][0]
        int curr1;//当前dp[i][1]
        int curr2;//当前dp[i][2]
        for (int i = 1; i < len; i++) {
            curr0 = Math.max(pre0, pre1 + prices[i]);
            curr1 = Math.max(pre1, pre2 - prices[i]);
            curr2 = pre0;

            pre0 = curr0;
            pre1 = curr1;
            pre2 = curr2;
        }
        return Math.max(pre0, pre2);//最大利润等于当前不持股和冷冻期的较大值
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        int i = maxProfit2(prices);
        System.out.println(i);
    }
}
