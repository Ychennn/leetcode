package com.yc.dp;

public class Solution8 {//按摩师

    public static int massage(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i + 1], nums[i] + dp[i]);
        }
        return Math.max(dp[nums.length + 1], dp[nums.length]);
    }

    public static int massage2(int[] nums) {
        int prev2 = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = prev;
            prev = Math.max(prev2 + nums[i], prev);
            prev2 = tmp;
        }
        return Math.max(prev, prev2);
    }


    public static void main(String[] args) {
        int massage = massage2(new int[]{1, 2, 3, 1});
        System.out.println(massage);
    }
}
