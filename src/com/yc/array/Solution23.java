package com.yc.array;


import java.util.Arrays;

public class Solution23 {//在排序数组中查找元素的第一个和最后一个位置⭐⭐⭐⭐⭐⭐⭐

    public static int[] searchRange(int[] nums, int target) {
        int a = search(nums, target);
        int b = search(nums, target + 1);
        if (a == nums.length || target != nums[a]) {
            return new int[]{-1, -1};
        }
        return new int[]{a, b - 1};
    }

    private static int search(int[] nums, int t) {//寻找target在数组中最左边的位置,left<right
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int m = (left + right) >>> 1;
            if (nums[m] < t)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }

    private static int search2(int[] nums, int t) {//left<=right
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = (left + right) >>> 1;
            if (nums[m] < t)
                left = m + 1;
            else
                right = m - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] result = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(result));
    }
}
