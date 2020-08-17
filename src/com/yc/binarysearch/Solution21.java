package com.yc.binarysearch;

public class Solution21 {//搜索旋转排序数组2⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;

            //如10111此种情况下 nums[start] == nums[mid]
            //分不清到底是前面有序还是后面有序,此时 start++ 即可
            //相当于去掉一个重复的干扰项
            //这里也可以使用right来判断,right--,但if (nums[mid] > nums[left]) 必须改为>=
            //防止{3,1}等情况
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] nums = new int[]{1, 3, 1, 1, 1};
        int target = 3;
        boolean b = solution21.search(nums, target);
        System.out.println(b);
    }
}
