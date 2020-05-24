package com.yc.dp;

public class Solution23 {//乘积最大子数组 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    public static int maxProduct(int[] nums) {
        /*由于负数的原因，最大值乘以负数就变成了最小值，所有使用二维数组来解题
        dp[i][j]：以 nums[i] 结尾的连续子数组的最值，计算最大值还是最小值由 j 来表示，j 就两个值；
        当 j = 0 的时候，表示计算的是最小值；
        当 j = 1 的时候，表示计算的是最大值
        dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        dp[i][1]：以 nums[i] 结尾的连续子数组的最大值*/
        int len = nums.length;
        if (len == 0) return nums[0];
        int dp[][] = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {//从一开始，因为0已被赋初值
            if (nums[i] > 0) {
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
            }
        }

        int max = dp[0][1];
        for (int i = 0; i < len; i++) {
            max = Math.max(dp[i][1], max);
        }
        return max;
    }

    public static int maxProduct2(int[] nums) {//空间优化
        int len = nums.length;
        if (len == 0) return nums[0];

        int preMax = nums[0];
        int preMin = nums[0];

        // 滚动变量
        int curMax;
        int curMin;

        int result = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            result = Math.max(result, curMax);

            // 赋值滚动变量
            preMax = curMax;
            preMin = curMin;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = maxProduct2(new int[]{-3, 0,-3});
        System.out.println(i);
    }
}
