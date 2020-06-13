package com.yc.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {//非递增顺序的最小子序列

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int sum = 0;
        int maxValueSum = 0;
        for (int i : nums) {
            sum += i;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            maxValueSum += nums[i];
            result.add(nums[i]);
            if (maxValueSum > (sum - maxValueSum)) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        //List<Integer> list = solution3.minSubsequence(new int[]{4, 3, 10, 9, 8});
        List<Integer> list = solution3.minSubsequence(new int[]{4, 4, 7, 6, 7});
        System.out.println(list);
    }
}
