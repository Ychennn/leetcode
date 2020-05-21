package com.yc.array;

public class Solution25 {//搜索旋转排序数组

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //找到目标值了直接返回
            if (nums[mid] == target) {
                return mid;
            }
            //如果左侧是有序的
            if (nums[left] <= nums[mid]) {
                //同时target在[ nums[begin],nums[mid] ]中，那么就在这段有序区间查找
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                    //否则去反方向查找
                } else {
                    left = mid + 1;
                }
            }
            //如果右侧是有序的
            else {
                //同时target在 ( nums[mid],nums[end] ]中，那么就在这段有序区间查找
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                    //否则去反方向查找
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int search = search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 0);
        System.out.println(search);
    }
}
