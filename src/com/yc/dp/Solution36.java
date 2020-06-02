package com.yc.dp;

public class Solution36 {//目标和⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐背包问题

    public static int findTargetSumWays(int[] nums, int S) {//动态规划
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //判断,如果nums总和的绝对值<S的绝对值直接返回0
        if (Math.abs(sum) < Math.abs(S)) return 0;

        int m = sum * 2;

        //创建dp二维数组,dp[i][j]代表使用前i个num +/- 组合得到j
        //数组dp[sum]之前代表负数,之后代表正数,dp[sum]代表dp[0]
        int[][] dp = new int[len][m + 1];

        //初始化二位数组
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }


        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                //边界,如 i=1&j=0 --> 0 - nums[i] --> -1 小于边界显然是错误的
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                //同理j=sum * 2 --> sum*2 + nums[i] 越界也是错误的
                int r = (j + nums[i]) < sum * 2 + 1 ? j + nums[i] : m;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];//动态转换方程
            }
        }
        return dp[len - 1][sum + S];
    }

    public static int findTargetSumWays2(int[] nums, int S) {//空间优化
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(sum) < Math.abs(S)) return 0;
        int m = sum * 2;
        int[] pre = new int[m + 1];
        if (nums[0] == 0) {
            pre[sum] = 2;
        } else {
            pre[sum + nums[0]] = 1;
            pre[sum - nums[0]] = 1;
        }
        for (int i = 1; i < len; i++) {
            int[] curr = new int[m + 1];
            for (int j = 0; j <= m; j++) {
                int l = j - nums[i] > 0 ? j - nums[i] : 0;
                int r = j + nums[i] < sum * 2 + 1 ? j + nums[i] : m;
                curr[j] = pre[l] + pre[r];
            }
            pre = curr;
        }
        return pre[sum + S];
    }

    public static void main(String[] args) {
        int ways = findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ways);
    }
}
