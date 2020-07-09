package com.yc.array;

import java.util.Arrays;

public class Solution20 {//下一个排列

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = nums.length - 1;
                for (; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        //交换对应的值
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        //从fromindex到to-1进行快排
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }
        //如果没有找到,即如654321,返回123456
        Arrays.sort(nums);
    }


    public static void main(String[] args) {
        int[] ints = {1, 3, 2};
        nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
