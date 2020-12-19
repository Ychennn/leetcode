package com.yc.offer_easy;

import java.util.*;

public class Solution10 {//数组中重复的数字⭐⭐⭐⭐

    public int findRepeatNumber3(int[] nums) {//hash
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {//排序
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber(int[] nums) {//统计个数⭐⭐⭐⭐
        int[] tmp = new int[nums.length];

        for (int num : nums) {
            tmp[num]++;
            if (tmp[num] > 1) return num;
        }
        return -1;
    }
}
