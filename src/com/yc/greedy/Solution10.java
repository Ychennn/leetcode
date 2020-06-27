package com.yc.greedy;

public class Solution10 {
    public int maxProfit(int[] prices) {//动态规划效率低
        int pre0 = 0;//代表前一天不持股的最大利润
        int pre1 = -prices[0];//代表前一天持股的最大利润

        int curr0;//代表当前不持股的最大利润,由前一天也不持股和前一天持股今天卖出相比较而得
        int curr1;//代表当前持股的最大利润,由前一天也持股和前一天不持股今天买入相比较而得

        for (int i = 1; i < prices.length; i++) {
            curr0 = Math.max(pre0, pre1 + prices[i]);
            curr1 = Math.max(pre1, pre0 - prices[i]);

            pre0 = curr0;
            pre1 = curr1;
        }
        return pre0;
    }

    public int maxProfit2(int[] prices) {//贪心算法
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
//            res += Math.max(prices[i + 1] - prices[i], 0);
        }
        //如{1,2,3,4} -->
        //res =  (prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])=  prices[3] - prices[0]
        //在索引为 1、2、3 的这三天,我们做的操作应该是买进昨天的,卖出今天的
        // 虽然这种操作题目并不允许,但是它等价于 ==> 在索引为0的那一天买入,在索引为3的那一天卖出

        return res;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int i = solution10.maxProfit2(prices);
        System.out.println(i);
    }
}
