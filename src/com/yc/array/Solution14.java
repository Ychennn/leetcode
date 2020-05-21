package com.yc.array;

import java.util.Arrays;

public class Solution14 {//数组中的K-diff数对
    public static int findPairs(int[] nums, int k) {//自己的方法
        Arrays.sort(nums);
        int index;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            index = i + 1;
            while (index < nums.length && (nums[index] - nums[i] <= k)) {
                if (nums[index] - nums[i] == k) {
                    count++;
                    break;
                }
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = findPairs(new int[]{3, 1, 4, 1, 5}, 2);
        System.out.println(i);
    }
}
