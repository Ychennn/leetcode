package com.yc.binarysearch;

public class Solution3 {//0～n-1中缺失的数字

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;//⭐⭐⭐
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;//⭐⭐⭐
        }
        return i;
    }

    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length;//⭐⭐⭐
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m;//⭐⭐⭐
        }
        return i;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = new int[]{0, 1, 3, 4, 5};
        int i = solution3.missingNumber(nums);
        System.out.println(i);
    }
}
