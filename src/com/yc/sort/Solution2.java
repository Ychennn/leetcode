package com.yc.sort;

import java.util.Arrays;

public class Solution2 {//选择排序

    public void selectSort(int[] nums) {
        int tmp;
        int minIdx;//记录最小值索引
        for (int i = 0; i < nums.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                tmp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{15, 9, 5, 10, 1};
        solution2.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
