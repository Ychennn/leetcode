package com.yc.bit;

public class Solution7 {//只出现一次的数字⭐⭐⭐⭐⭐

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] nums = new int[]{2, 2, 1};
        int i = solution7.singleNumber(nums);
        System.out.println(i);
    }
}
