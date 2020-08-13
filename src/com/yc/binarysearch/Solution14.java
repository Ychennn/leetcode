package com.yc.binarysearch;

public class Solution14 {//在排序数组中查找数字1 ⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int search(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0) return count;
        int left = 0;
        int right = nums.length - 1;
        //计算出最左边的值(如果数组中有target值,返回它的下标,否则返回在数组中对应的位置)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //注意边界,可能返回的不是在数组中的下标,直接返回count=0
        if (left >= nums.length || nums[left] != target) {
            return count;
        }

        //注意边界
        while (left < nums.length && nums[left] == target) {
            count++;
            left++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int i = solution14.search(nums, target);
        System.out.println(i);
    }
}
