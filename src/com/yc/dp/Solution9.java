package com.yc.dp;

import java.util.HashMap;

public class Solution9 {//连续的子数组和⭐⭐⭐⭐

    public static boolean checkSubarraySum(int[] nums, int k) {//暴力解法
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k || (k != 0 && sum % k == 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkSubarraySumPro(int[] nums, int k) {//⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = checkSubarraySumPro(new int[]{0, 0}, 0);
        boolean b2 = checkSubarraySumPro(new int[]{0}, 0);
        boolean b3 = checkSubarraySumPro(new int[]{23, 2, 6, 4, 7}, 6);
        System.out.println(b);
    }
}
