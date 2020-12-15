package com.yc.sort;

public class Solution2 {//选择排序

    public void selectSort(int[] nums) {
        int tmp, minIdx;//minIdx记录最小值索引

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
}
