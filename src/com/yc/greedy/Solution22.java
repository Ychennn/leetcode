package com.yc.greedy;

public class Solution22 {//最长连续递增序列

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1) return nums.length;
        int res = 1, count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
