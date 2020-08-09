package com.yc.binarysearch;

public class Solution2 {//二分查找

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;//⭐⭐⭐

        //主要搜索区间边界的问题
        while (left <= right) {//⭐⭐⭐
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;//⭐⭐⭐
            else left = mid + 1;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//⭐⭐⭐

        //主要搜索区间边界的问题
        while (left < right) {//⭐⭐⭐
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;//⭐⭐⭐
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{-1, 2, 2, 5, 9, 12};
        int target = 2;
        int i = solution2.search(nums, target);
        System.out.println(i);
    }
}
