package com.yc.dp;

public class Solution7 {//连续子数组的最大和

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
//            if (sum >= 0) {
//                sum += nums[i];
//            } else {
//                sum = nums[i];
//            }
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {//动态规划法
        if (nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max,nums[i]);
        }
        return max;
    }


    public static void main(String[] args) {
//        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int i = maxSubArray(new int[]{1, 2});
        System.out.println(i);
    }
}
