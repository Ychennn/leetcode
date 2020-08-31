package com.yc.dpointer;

import java.util.Arrays;

public class Solution14 {//数组中的K-diff数对

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int index;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            index = i + 1;
            for (int j = i + 1; j < nums.length; j++) {
                //因为数组排序的原因,当前值如果和nums[i]差值大于k
                //后面的值之差肯定也会大于k,直接返回
                if (nums[j] - k > nums[i]) {
                    break;
                }
                if (nums[j] - k == nums[i]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] nums = new int[]{3, 1, 4, 1, 5};
        int k = 2;
        int i = solution14.findPairs(nums, k);
        System.out.println(i);
    }
}
