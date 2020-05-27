package com.yc.array;

import java.util.Arrays;

public class Solution17 {//删除排序数组中的重复元素

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;//数组中去重的个数
        int index = 0;//指针
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            if (i < nums.length) {
                nums[++index] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] ints = new int[]{1, 2};
        int i = removeDuplicates(ints);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
    }
}
