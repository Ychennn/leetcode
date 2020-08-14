package com.yc.binarysearch;

import java.util.Arrays;

public class Solution15 {//两数之和2 - 输入有序数组⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    //固定第一个数,然后寻找第二个数,第二个数等于目标值减去第一个数的差
    //为了避免重复寻找,在寻找第二个数时,只在第一个数的右侧寻找
    public int[] twoSum(int[] numbers, int target) {//二分查找
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;//防止重复查找
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target) {//双指针
        int lindex = 0;
        int rindex = numbers.length - 1;
        int tmp;
        while (lindex < rindex) {
            tmp = numbers[lindex] + numbers[rindex];
            if (tmp == target) {
                return new int[]{lindex + 1, rindex + 1};
            } else if (tmp < target) {
                lindex++;
            } else {
                rindex--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        int[] twoSum = solution15.twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }
}
