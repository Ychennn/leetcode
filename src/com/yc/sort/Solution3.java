package com.yc.sort;

import java.util.Arrays;

public class Solution3 {//快速排序

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;//区间只有一个数或区间不存在

        int val = nums[start];
        int l = start;
        int r = end;

        while (l < r) {
            while (l < r && nums[r] >= val) {
                r--;
            }
            nums[l] = nums[r];

            while (l < r && nums[l] <= val) {
                l++;
            }
            nums[r] = nums[l];
        }

        nums[l] = val;
        quickSort(nums, start, l - 1);
        quickSort(nums, r + 1, end);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {3, 1, 1, 2, 4};
        solution3.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
