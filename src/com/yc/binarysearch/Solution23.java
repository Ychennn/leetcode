package com.yc.binarysearch;

public class Solution23 {//寻找峰值⭐⭐⭐⭐⭐⭐⭐

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        //必须为left < right,当 mid 存在时 mid+1 才不会越界
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        int[] nums = new int[]{1};
        int i = solution23.findPeakElement(nums);
        System.out.println(i);
    }
}
