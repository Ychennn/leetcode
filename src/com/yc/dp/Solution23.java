package com.yc.dp;

public class Solution23 {//买股票的最佳时机含手续费 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        /*dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益'
        j = 0 表示不持股，j = 1 表示持股
        并且规定在买入股票的时候，扣除手续费*/
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            /*今天不持股的最大利润可以由昨天也不持股和昨天持股今天卖出的较大值得出，
            由于昨天持股的利润是已经减去了买进和手续费，所以直接加今天的prices[i]即可得到利润*/
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /*今天持股的最大利润可以由昨天也不持股和昨天持股今天卖出的较大值得出
            如果昨天不持股，需减去今天的prices[i]和手续费*/
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[len - 1][0];
    }

    public static int maxProfit2(int[] prices, int fee) {//空间优化
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int pre0 = 0;//对应表示dp[0][0]
        int pre1 = -prices[0] - fee;//对应表示dp[0][1]

        int curr0;
        int curr1;

        for (int i = 1; i < len; i++) {
            curr0 = Math.max(pre0, pre1 + prices[i]);
            curr1 = Math.max(pre1, pre0 - prices[i] - fee);

            pre0 = curr0;
            pre1 = curr1;
        }
        return pre0;
    }

    public static void main(String[] args) {
        int i = maxProfit2(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(i);
    }
}
