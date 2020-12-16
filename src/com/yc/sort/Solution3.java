package com.yc.sort;

public class Solution3 {//快速排序

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;//区间只有一个数或区间不存在

        int val = nums[left];
        int l = left;
        int r = right;

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
        quickSort(nums, left, l - 1);
        quickSort(nums, r + 1, right);
    }
}
