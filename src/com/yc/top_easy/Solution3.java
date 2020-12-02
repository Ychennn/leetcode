package com.yc.top_easy;

import java.util.Arrays;

public class Solution3 {//在排序数组中查找元素的第一个和最后一个位置⭐⭐⭐⭐⭐

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0]
                || target > nums[nums.length - 1]) ;

        int left = leftIdx(nums, target);//找到该值最左的索引
        int right = leftIdx(nums, target + 1);//找到比目标值大1的最左索引
        if (left == nums.length || target != nums[left]) {
            //处理nums中不含目标值的情况
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};
    }

    //二分查找,找目标值最左的索引,若该值不存在则返回该值在数组中应该的索引
    //如{1,3,4},找2,此时返回 idx =1
    private int leftIdx(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] idxs = solution3.searchRange(nums, 6);
        System.out.println(Arrays.toString(idxs));
    }
}
