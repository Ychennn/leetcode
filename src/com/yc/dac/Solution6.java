package com.yc.dac;

import java.util.Arrays;

public class Solution6 {//数组中的第K个最大元素

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
