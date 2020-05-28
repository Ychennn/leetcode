package com.yc.dp;

public class Solution29 {//最低票价

    public static int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0)
            return 0;
        //初始化出现日期数，如{1, 4, 6, 7, 8, 20}，则初始为21天(第0天)
        int[] dp = new int[days[days.length - 1] + 1];
        //标记要旅游的对应日期
        for (int day : days) {
            dp[day] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];//当前天不需要旅行，今天的话费就等于上次旅行时候所花费的票钱
                continue;
            }
            int price0 = dp[i - 1] + costs[0];//当前的价格等于上次旅行的前加今天一天的票钱

            /*如果今天距离第一天已经超过7天了
            则花费: dp[i-7](7天前已经花费的钱)+cost[1](7天前买了一张7天的票)
            否则就是直接第一天买了一张7天票，30同理*/
            int price1 = i >= 7 ? dp[i - 7] + costs[1] : costs[1];
            int price2 = i >= 30 ? dp[i - 30] + costs[2] : costs[2];

            dp[i] = Math.min(Math.min(price0, price1), price2);
        }
        return dp[dp.length - 1];//最后一天花费多少钱
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};//旅游的天数
        int[] costs = new int[]{2, 7, 15};//旅行1，7，30对应的票价
        int tickets = mincostTickets(days, costs);
        System.out.println(tickets);
    }
}
