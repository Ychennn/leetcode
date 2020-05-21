package com.yc.dp;

public class Solution5 {//打家劫舍⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }

    public static void main(String[] args) {
        int rob = rob(new int[]{2, 7, 9, 3, 1, 7});
        System.out.println(rob);

    }
}
