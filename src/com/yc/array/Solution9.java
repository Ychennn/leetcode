package com.yc.array;

import java.util.Arrays;

public class Solution9 {//移动零

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 5};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
