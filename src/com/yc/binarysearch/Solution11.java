package com.yc.binarysearch;

public class Solution11 {//魔术索引⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int findMagicIndex(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    //因为要求返回最小的索引,如果直接二分查找是不能得出正确答案的
    public int helper(int[] nums, int left, int right) {//递归处理左半块和右半块
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        //先处理左半块,如果左边有返回值切!=-1,肯定是最小的,符合题意
        int res = helper(nums, left, mid - 1);

        //而且代码的顺序不能改变,如nums[mid] == mid放在前面就返回是错误的,因为求最小索引
        if (res != -1) {
            return res;
        } else if (nums[mid] == mid) {
            return mid;
        } else {
            return helper(nums, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums = new int[]{0, 2, 3, 4, 5};
        int index = solution11.findMagicIndex(nums);
        System.out.println(index);
    }
}
