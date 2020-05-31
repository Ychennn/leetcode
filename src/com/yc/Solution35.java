package com.yc;

import java.util.Arrays;

public class Solution35 {//最长上升子序列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int lengthOfLIS(int[] nums) {//动态规划,有二分查找和贪心的优化版需二刷
        int len = nums.length;
        if (len < 2) return len;

        //由于一个子序列一定会以一个数结尾，于是将状态定义成dp[i]
        // dp[i]表示以 nums[i] 结尾的上升子序列]的长度
        // 注意:这个定义中nums[i]必须被选取,且必须是这个子序列的最后一个元素
        int[] dp = new int[len];

        Arrays.fill(dp, 1);//初始化,因为以当前nums[i]结尾的最小长度就是本身

        int res = 0;//这步是为了优化下面获取最大值的工作
        //因为dp[i]是以当前nums[i]结尾的最大值,可能不是最大值,需逐一比较的得出
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //因为dp[j]代表以nums[j]结尾的最大值,而nums[j] < nums[i]所以最大值+1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            res = Math.max(res, dp[i]);
//        }
        return res;
    }

    public static void main(String[] args) {
        int i = lengthOfLIS(new int[]{1, 2});
        System.out.println(i);
    }
}
