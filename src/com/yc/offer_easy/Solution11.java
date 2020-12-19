package com.yc.offer_easy;

public class Solution11 {//和为s的两个数字

    public int[] twoSum(int[] nums, int target) {//双指针
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) return new int[]{nums[l], nums[r]};
            else if (sum > target) r--;
            else l++;
        }
        return new int[]{-1, -1};
    }
}
