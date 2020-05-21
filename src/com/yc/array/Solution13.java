package com.yc.array;

import java.util.Arrays;

public class Solution13 {//最接近的三数之和
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[2];
        int left;
        int right;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target-sum) < Math.abs(target-closet)) {
                    closet = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return closet;
                }
            }
        }
        return closet;
    }

    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }
}
