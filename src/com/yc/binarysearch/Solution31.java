package com.yc.binarysearch;

import java.util.Arrays;

public class Solution31 {//长度最小的子数组⭐⭐⭐⭐⭐⭐⭐⭐

    public int minSubArrayLen(int s, int[] nums) {//前缀和 + 二分查找
        int len = nums.length;
        if (len == 0) return 0;
        int res = Integer.MAX_VALUE;

        //前缀和数组
        //nums[i]代表前i个元素的前缀和
        int[] prefixsums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixsums[i] = prefixsums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= len; i++) {
            int target = prefixsums[i] + s;

            //源码中,如果未找到该数字,则会返回在数组对应的位置+1的负数即 -(low + 1);
            int index = Arrays.binarySearch(prefixsums, target);

            if (index < 0) index = -index - 1;

            if (index <= len) res = Math.min(res, index - i);
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        int s = 7;
        int len = solution31.minSubArrayLen(s, arr);
        System.out.println(len);
    }
}
