package com.yc.array;

public class Solution28 {//最大子序和

    public static int maxSubArray(int[] nums) {//暴力法
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSubArrayPro(int[] nums) {//优化
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int i = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//        int i = maxSubArrayPro(new int[]{-1});
        int i = maxSubArrayPro(new int[]{-2, 3, -1, 1, 3});
        System.out.println(i);
    }
}
