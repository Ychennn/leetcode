package com.yc.sort;

import java.util.Arrays;

public class Solution {//冒泡排序

    public void bubbleSort(int[] nums) {
        int tmp;

        //标志是否交换,如果在一次排序中,没有数据交换顺序,停止排序
        boolean flag;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{15, 9, 5, 10, 1};
        solution.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
