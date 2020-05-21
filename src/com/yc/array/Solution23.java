package com.yc.array;

import java.util.Arrays;

public class Solution23 {//数组拆分 I
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        for (int i = 0; i < nums.length; i += 2) {
            min += nums[i];
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
