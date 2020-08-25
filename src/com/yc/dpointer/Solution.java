package com.yc.dpointer;

import java.util.Arrays;

class Solution {//删除排序数组中的重复项⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        //最初的数字没有算进去
        return i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2};
        int i = solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }
}