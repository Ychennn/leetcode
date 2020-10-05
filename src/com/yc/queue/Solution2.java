package com.yc.queue;

public class Solution2 {//第 k 个数(丑数)⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int getKthMagicNumber(int k) {//动态规划
        int p3 = 0, p5 = 0, p7 = 0;
        int[] dp = new int[k];

        //第一个数为 1
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
            if (dp[i] == dp[p7] * 7) p7++;
        }
        return dp[k - 1];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.getKthMagicNumber(7);
        System.out.println(i);
    }
}
