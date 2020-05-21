package com.yc.array;

public class Solution7 {//买股票的最佳时机
    public static int maxProfit(int prices[]) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(ints);
        System.out.println("最大利润为："+i);
    }
}
