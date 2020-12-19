package com.yc.offer_easy;

import java.util.Arrays;

public class Solution12 {//调整数组顺序使奇数位于偶数前面⭐⭐⭐⭐⭐⭐

    public int[] exchange(int[] nums) {//双指针 + 原地修改
        int l = 0, r = nums.length - 1, tmp;
        while (l < r) {
            //找到左边最右的偶数的索引
            while (l < r && (nums[l] & 1) == 1) l++;
            //找到右边最左的技术索引
            while (l < r && (nums[r] & 1) == 0) r--;

            //交换
            tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] nums = {1, 2, 3, 4};
        int[] exchange = solution12.exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
