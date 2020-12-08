package com.yc.top_medium;

import java.util.Arrays;

public class Solution6 {//最大数⭐⭐⭐⭐

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }

        //排序: 将2个字符串拼接,比较不同顺序拼接后的大小,决定顺序(类似于字典序降序)
        //{3, 30, 34, 5, 9}  --> {9, 5, 34, 3, 30}
        Arrays.sort(strs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }

        if (res.charAt(0) == '0') return "0";
        return res.toString();
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = {3, 30, 34, 5, 9};
        String s = solution6.largestNumber(nums);
        System.out.println(s);
    }
}
