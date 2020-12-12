package com.yc.top_medium;

import java.util.Arrays;

public class Solution12 {//旋转数组⭐⭐⭐⭐⭐

    public void rotate(int[] nums, int k) {//使用额外的数组
        int[] clone = nums.clone();

        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = clone[i];
        }
    }

    public void rotate2(int[] nums, int k) {//使用反转
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    //原始数组:{1, 2, 3, 4, 5, 6, 7}
    //反转所有数字后:{7, 6, 5, 4, 3, 2, 1}
    //反转前k个数字后:{5, 6, 7, 4, 3, 2, 1}
    //反转后n-k个数字后:{5, 6, 7, 1, 2, 3, 4}--> 最终结果

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        solution12.rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
