package com.yc.binarysearch;

public class Solution16 {//搜索插入位置⭐⭐⭐⭐⭐⭐⭐

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        //特殊判断
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }

        //二分查找插入的位置
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;
        int i = solution16.searchInsert(nums, target);
        System.out.println(i);
    }
}
