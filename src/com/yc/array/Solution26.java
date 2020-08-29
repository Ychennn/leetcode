package com.yc.array;

import java.util.HashMap;

public class Solution26 {//和为K的子数组

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int subarraySumPro(int[] nums, int k) {//⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//防止数组中第一个数就和k相等不被记录
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int i = subarraySumPro(new int[]{1, 2, 3}, 3);
        System.out.println(i);
    }
}
