package com.yc.dac;

public class Solution5 {//主要元素

    public int majorityElement(int[] nums) {

        int res = 0, count = 0;

        for (int num : nums) {
            if (count == 0) res = num;

            count += res == num ? 1 : -1;
        }

        count = 0;
        for (int num : nums) {
            if (num == res) count++;
        }

        return count > nums.length / 2 ? res : -1;
    }
}
