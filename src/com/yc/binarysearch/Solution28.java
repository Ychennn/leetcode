package com.yc.binarysearch;

public class Solution28 {//寻找旋转排序数组中的最小值⭐⭐⭐⭐⭐

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            //不与nums[left]元素比较是因为确定不了最小元素是在mid的左边还是右边
            //如{1,2,4,5,6,7,0} 和 {7,0,1,2,4,5,6}
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int min = solution28.findMin(nums);
        System.out.println(min);
    }
}
